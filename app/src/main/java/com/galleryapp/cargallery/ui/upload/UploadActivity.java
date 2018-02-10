package com.galleryapp.cargallery.ui.upload;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.util.FileUtil;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by yuana on 2/10/18.
 */

public class UploadActivity extends AppCompatActivity implements UploadView {

    private static final int RC_PICK_IMAGE = 12;
    private static final int RC_PERMISSION_READ_EXTERNAL_STORAGE = 13;
    private ImageView ivUpload;
    private Button btnUpload;
    private UploadPresenter mPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        initView();
        initPresenter();
        initProgress();
    }

    private void initProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading...");
    }

    private void initPresenter() {
        mPresenter = new UploadPresenter(this);
    }

    private void initView() {
        ivUpload = (ImageView) findViewById(R.id.ivUpload);
        btnUpload = (Button) findViewById(R.id.btnUpload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReadFilePermission();
            }
        });
    }

    private void checkReadFilePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                Toast.makeText(this, "no access for read file permission",
                        Toast.LENGTH_SHORT).show();

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, RC_PERMISSION_READ_EXTERNAL_STORAGE);

                // RC_PERMISSION_READ_EXTERNAL_STORAGE is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            openGallery();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case RC_PERMISSION_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    openGallery();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    checkReadFilePermission();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }

    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), RC_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_PICK_IMAGE) {
            Uri selectedImageUri = data.getData();
//            ivUpload.setImageURI(selectedImageUri);
//            String selectedImagePath = getPath(selectedImageUri);
//            Log.d("UploadActivity", selectedImagePath);

            String path = FileUtil.getPath(this, selectedImageUri);
            File file = new File(path);
            doUploadImage(file);
        }
    }

    private void doUploadImage(File file) {
        mPresenter.doUploadImage(file);
    }


    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showUploadedImage(String data) {
        Picasso.with(this)
                .load(data)
                .placeholder(R.drawable.ic_car_logo)
                .fit()
                .centerCrop()
                .into(ivUpload);
    }
}
