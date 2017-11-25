package com.galleryapp.cargallery.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.ui.detail.DetailActivity;
import com.galleryapp.cargallery.ui.home.adapter.CarAdapter;
import com.galleryapp.cargallery.ui.home.adapter.CarAdapterListener;
import com.galleryapp.cargallery.ui.login.LoginActivity;
import com.galleryapp.cargallery.util.Const;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class HomeActivity extends AppCompatActivity implements HomeView, CarAdapterListener {

    private HomePresenter mPresenter;
    private RecyclerView rvHomeCar;
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initPresenter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initPresenter() {
        mPresenter = new HomePresenter(this);
    }

    private void initData() {
        mPresenter.getCarAll();
    }

    private void initView() {
        rvHomeCar = (RecyclerView) findViewById(R.id.rvHomeCar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLogout:
                mPresenter.logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void showCarAll(List<Car> carList) {
        carAdapter = new CarAdapter(carList);
        carAdapter.setAdapterListener(this);
        rvHomeCar.setLayoutManager(new LinearLayoutManager(this));
        rvHomeCar.setAdapter(carAdapter);
    }

    @Override
    public void showErrorCarAll(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorDeleteCar(String message) {
        Toast.makeText(this,  message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessDeleteCar(Car car) {
        carAdapter.remove(car);
        Toast.makeText(HomeActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemCarClick(Car car) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Const.Extra.DATA, car);
        startActivity(intent);
    }

    @Override
    public void onItemCarLongClick(final Car car) {
        new AlertDialog.Builder(this)
                .setTitle("Hapus data ?")
                .setCancelable(false)
                .setMessage("Hapus data Car : " + car.getMake())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPresenter.deleteCar(car);
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    @Override
    public void displayCarImage(ImageView ivItemCarImage, Car item) {
        Picasso.with(this).load(item.getImageUrl()).into(ivItemCarImage);
    }
}
