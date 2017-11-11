package com.galleryapp.cargallery.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.util.Const;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 11/11/17
 */

public class DetailActivity extends AppCompatActivity {

    private Car car;
    private TextView tvDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initIntentData();
        initView();
        diplayData();
    }

    private void initIntentData() {
        car = getIntent().getParcelableExtra(Const.Extra.DATA);
        if (car == null) finish();
    }

    private void initView() {
        tvDetail = (TextView) findViewById(R.id.tvDetail);
    }

    private void diplayData() {
        tvDetail.setText(car.toString());
    }
}
