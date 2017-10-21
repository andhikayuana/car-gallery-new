package com.galleryapp.cargallery.ui.home;

import android.util.Log;

import com.galleryapp.cargallery.data.local.Session;
import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.data.network.RestClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yuana
 * @since 10/21/17
 */

public class HomePresenter {

    private final HomeView mView;

    public HomePresenter(HomeView homeView) {
        mView = homeView;
    }

    public void logout() {
        Session.getInstance().setLogin(false);
        mView.gotoLogin();
    }

    public void getCarAll() {
        RestClient.getInstance()
                .getApi()
                .getCarAll()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()) {

                            JsonObject body = response.body();
                            JsonArray data = body.get("data").getAsJsonArray();

                            Type type = new TypeToken<List<Car>>() {
                            }.getType();

                            List<Car> carList = new Gson().fromJson(data, type);

                            mView.showCarAll(carList);

                            Log.d("List<Car>", carList.toString());

                        } else {
                            // TODO: 10/14/17  error api
                            Log.d("DATA", "ERROR");
                            mView.showErrorCarAll("ERROR RESPONSE");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        // TODO: 10/14/17 error
                        Log.d("DATA", t.getMessage());
                        mView.showErrorCarAll(t.getMessage());
                    }
                });
    }
}
