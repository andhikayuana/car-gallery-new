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

    public ApiService getApi(String baseUrl) {
        return getRetrofit(baseUrl).create(ApiService.class);
    }

    public ApiService getApi() {
        return getApi(Const.BASE_URL);
    }

    @NonNull
    private Retrofit getRetrofit(String baseUrl) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
