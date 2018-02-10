package com.galleryapp.cargallery.ui.upload;

import com.galleryapp.cargallery.data.network.RestClient;
import com.galleryapp.cargallery.util.Const;
import com.google.gson.JsonObject;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yuana on 2/10/18.
 */

public class UploadPresenter {

    private final UploadView mView;

    public UploadPresenter(UploadView uploadView) {
        mView = uploadView;
    }

    public void doUploadImage(File file) {
        // TODO: 2/10/18

        mView.showProgress();

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        RestClient.getInstance()
                .getApi(Const.BASE_URL_UPLOAD)
                .uploadImage(body)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        mView.dismissProgress();

                        if (response.isSuccessful()) {
                            // TODO: 2/10/18 parsing image

                            JsonObject body = response.body();
                            String data = body.get("data").getAsString();

                            mView.showUploadedImage(data);
                        }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        mView.dismissProgress();
                    }
                });
    }
}
