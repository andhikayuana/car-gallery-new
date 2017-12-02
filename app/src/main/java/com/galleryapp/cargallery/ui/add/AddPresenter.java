package com.galleryapp.cargallery.ui.add;

import android.util.Log;

import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.data.network.RestClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 12/2/17
 */

public class AddPresenter {

    private final AddView mView;

    public AddPresenter(AddView addView) {
        mView = addView;
    }

    public void saveCar() {
        String year = mView.getYear();
        String make = mView.getMake();
        String model = mView.getModel();

        // TODO: 12/2/17 validation

        RestClient.getInstance()
                .getApi()
                .saveCar(year, make, model)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()) {

                            JsonObject body = response.body();
                            JsonObject data = body.get("data").getAsJsonObject();
                            Car carResponse = new Gson().fromJson(data, Car.class);

                            mView.showSuccessSaveCar(carResponse);

                        } else {
                            Log.d("DATA", "ERROR");
                            mView.showErrorSaveCar("ERROR");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("DATA", t.getMessage());
                        mView.showErrorSaveCar(t.getMessage());
                    }
                });
    }
}
