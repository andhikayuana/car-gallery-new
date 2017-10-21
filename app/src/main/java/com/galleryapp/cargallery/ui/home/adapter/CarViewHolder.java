package com.galleryapp.cargallery.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;

/**
 * @author yuana
 * @since 10/21/17
 */

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView tvItemCarMake;

    public CarViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvItemCarMake = (TextView) itemView.findViewById(R.id.tvItemCarMake);
    }

    public void bind(Car item) {
        tvItemCarMake.setText(item.getMake());
    }
}
