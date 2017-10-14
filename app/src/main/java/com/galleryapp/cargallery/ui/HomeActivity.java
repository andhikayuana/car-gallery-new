package com.galleryapp.cargallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.galleryapp.cargallery.R;
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
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
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

                            Log.d("List<Car>", carList.toString());

                        } else {
                            // TODO: 10/14/17  error api
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        // TODO: 10/14/17 error
                    }
                });
    }

    private void initView() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLogout:
                Session.getInstance().setLogin(false);
                gotoLogin();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
