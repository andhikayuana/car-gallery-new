package com.galleryapp.cargallery.data.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public interface ApiService {

    @GET("cars")
    Call<JsonObject> getCarAll();

    @GET("cars/{id}")
    Call<JsonObject> getCarById(@Path("id") int id);

    @DELETE("cars/{id}")
    Call<JsonObject> deleteCar(@Path("id") int id);

    @FormUrlEncoded
    @POST("cars")
    Call<JsonObject> saveCar(
            @Field("year") String year,
            @Field("make") String make,
            @Field("model") String model
    );
}
