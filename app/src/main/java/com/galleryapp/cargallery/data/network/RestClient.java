package com.galleryapp.cargallery.data.network;

import android.support.annotation.NonNull;

import com.galleryapp.cargallery.util.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public class RestClient {

    private static RestClient ourInstance;

    private RestClient() {
    }

    public static RestClient getInstance() {
        if (ourInstance == null) ourInstance = new RestClient();
        return ourInstance;
    }

    public ApiService getApi() {
        return getRetrofit().create(ApiService.class);
    }

    @NonNull
    private Retrofit getRetrofit() {
        return new Retrofit
                .Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
