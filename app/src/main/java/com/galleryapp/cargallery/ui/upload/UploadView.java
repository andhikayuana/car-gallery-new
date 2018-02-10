package com.galleryapp.cargallery.ui.upload;

/**
 * Created by yuana on 2/10/18.
 */

public interface UploadView {

    void showProgress();

    void dismissProgress();

    void showUploadedImage(String data);
}
