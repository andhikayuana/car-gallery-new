package com.galleryapp.cargallery.data.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public interface ApiService {

    @GET("cars")
    Call<JsonObject> getCarAll();
}
