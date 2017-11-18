package com.galleryapp.cargallery.ui.detail;

import com.galleryapp.cargallery.data.model.Car;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 11/18/17
 */

public interface DetailView {
    void showErrorCarById(String message);

    void showSuccessCarById(Car car);
}
