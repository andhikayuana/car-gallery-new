package com.galleryapp.cargallery.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.galleryapp.cargallery.data.model.Car;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 12/23/17
 */

public class PeriodicCheckCarsReceiver extends BroadcastReceiver {

    public static final String TAG = PeriodicCheckCarsReceiver.class.getSimpleName();
    private final PeriodicCheckCarsReceiverListener mListener;

    public PeriodicCheckCarsReceiver(PeriodicCheckCarsReceiverListener listener) {
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("DATA");
        JsonArray jsonCars = new Gson().fromJson(data, JsonArray.class);

        Type type = new TypeToken<List<Car>>() {
        }.getType();

        List<Car> carList = new Gson().fromJson(jsonCars, type);

        mListener.handleCarsFromReceiver(carList);
    }

    public interface PeriodicCheckCarsReceiverListener {

        void handleCarsFromReceiver(List<Car> carList);
    }
}
