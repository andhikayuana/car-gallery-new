package com.galleryapp.cargallery.ui.add;

import com.galleryapp.cargallery.data.model.Car;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 12/2/17
 */

public interface AddView {

    String getYear();

    String getMake();

    String getModel();

    void showErrorSaveCar(String message);

    void showSuccessSaveCar(Car carResponse);
}
