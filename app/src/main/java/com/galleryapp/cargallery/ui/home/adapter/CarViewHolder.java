package com.galleryapp.cargallery.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;

/**
 * @author yuana
 * @since 10/21/17
 */

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView tvItemCarMake;
    private ImageView ivItemCarImage;
    private TextView tvItemCarModel;
    private TextView tvItemCarYear;
    private RelativeLayout rlItemCar;

    public CarViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvItemCarMake = (TextView) itemView.findViewById(R.id.tvItemCarMake);
        ivItemCarImage = (ImageView) itemView.findViewById(R.id.ivItemCarImage);
        tvItemCarModel = (TextView) itemView.findViewById(R.id.tvItemCarModel);
        tvItemCarYear = (TextView) itemView.findViewById(R.id.tvItemCarYear);
        rlItemCar = (RelativeLayout) itemView.findViewById(R.id.rlItemCar);
    }

    public void bind(final Car item, final CarAdapterListener mListener) {
        tvItemCarMake.setText(item.getMake());
        tvItemCarModel.setText(item.getModel());
        tvItemCarYear.setText(item.getYear());
        rlItemCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemCarClick(item);
            }
        });
        rlItemCar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onItemCarLongClick(item);
                return true;
            }
        });
    }
}
