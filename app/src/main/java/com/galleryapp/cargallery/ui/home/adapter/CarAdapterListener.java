package com.galleryapp.cargallery.ui.home.adapter;

import android.widget.ImageView;

import com.galleryapp.cargallery.data.model.Car;

/**
 * @author yuana
 * @since 10/21/17
 */

public interface CarAdapterListener {

    void onItemCarClick(Car car);

    void onItemCarLongClick(Car car);

    void displayCarImage(ImageView ivItemCarImage, Car item);
}
