package com.galleryapp.cargallery.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.galleryapp.cargallery.data.network.RestClient;
import com.galleryapp.cargallery.receiver.PeriodicCheckCarsReceiver;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 12/23/17
 */

public class PeriodicCheckCarsService extends Service {

    private static final String TAG = PeriodicCheckCarsService.class.getSimpleName();
    private Timer mTimer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate Service");

        requestDataWithInterval();
    }

    private void requestDataWithInterval() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                RestClient.getInstance()
                        .getApi()
                        .getCarAll()
                        .enqueue(new Callback<JsonObject>() {
                            @Override
                            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                                if (response.isSuccessful()) {

                                    JsonObject body = response.body();
                                    JsonArray data = body.get("data").getAsJsonArray();

                                    sendToReceiver(data.toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonObject> call, Throwable t) {

                            }
                        });
            }
        }, 3000, 3000);
    }

    private void sendToReceiver(String jsonCars) {
        Intent intent = new Intent();
        intent.setAction(PeriodicCheckCarsReceiver.TAG);
        intent.putExtra("DATA", jsonCars);
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        Log.d(TAG, "onDestroy Service");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
