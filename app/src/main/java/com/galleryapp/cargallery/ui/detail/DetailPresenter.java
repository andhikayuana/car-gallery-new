package com.galleryapp.cargallery.ui.detail;

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
 * @since 11/18/17
 */

public class DetailPresenter {

    private final DetailView mView;

    public DetailPresenter(DetailView detailView) {
        mView = detailView;
    }

    public void getCarById(Car car) {
        RestClient.getInstance()
                .getApi()
                .getCarById(car.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {

                            JsonObject body = response.body();
                            JsonObject data = body.get("data").getAsJsonObject();
                            Car carResponse = new Gson().fromJson(data, Car.class);

                            mView.showSuccessCarById(carResponse);

                        } else {
                            // TODO: 11/18/17
//                            error here
                            Log.d("DATA", "ERROR");
                            mView.showErrorCarById("ERROR");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("DATA", t.getMessage());
                        mView.showErrorCarById(t.getMessage());
                    }
                });
    }
}
