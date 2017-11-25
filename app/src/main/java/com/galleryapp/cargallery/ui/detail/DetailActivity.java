package com.galleryapp.cargallery.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.util.Const;
import com.squareup.picasso.Picasso;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 11/11/17
 */

public class DetailActivity extends AppCompatActivity implements DetailView {

    private Car car;
    private DetailPresenter mPresenter;
    private TextView tvId;
    private TextView tvYear;
    private TextView tvMake;
    private TextView tvModel;
    private ImageView ivImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initIntentData();
        initPresenter();
        initData();
    }

    private void initView() {
        tvId = (TextView) findViewById(R.id.tvId);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMake = (TextView) findViewById(R.id.tvMake);
        tvModel = (TextView) findViewById(R.id.tvModel);
        ivImage = (ImageView) findViewById(R.id.ivImage);
    }

    private void initData() {
        mPresenter.getCarById(car);
    }

    private void initPresenter() {
        mPresenter = new DetailPresenter(this);
    }

    private void initIntentData() {
        car = getIntent().getParcelableExtra(Const.Extra.DATA);
        if (car == null) finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(Car car) {
        // TODO: 11/18/17 what you want
        tvId.setText(String.valueOf(car.getId()));
        tvMake.setText(car.getMake());
        tvModel.setText(car.getModel());
        tvYear.setText(car.getYear());
        Picasso.with(this)
                .load(car.getImageUrl())
                .placeholder(R.drawable.ic_car_logo)
                .into(ivImage);
    }
}
