package com.galleryapp.cargallery.ui.home;

import com.galleryapp.cargallery.data.model.Car;

import java.util.List;

/**
 * @author yuana
 * @since 10/21/17
 */

public interface HomeView {

    void gotoLogin();

    void showCarAll(List<Car> carList);

    void showErrorCarAll(String message);
}
