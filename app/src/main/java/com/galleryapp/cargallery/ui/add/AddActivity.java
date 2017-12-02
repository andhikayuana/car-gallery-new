package com.galleryapp.cargallery.ui.add;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.model.Car;
import com.galleryapp.cargallery.util.Const;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 12/2/17
 */

public class AddActivity extends AppCompatActivity implements AddView {

    private EditText etYear;
    private EditText etMake;
    private EditText etModel;
    private AddPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new AddPresenter(this);
    }

    private void initView() {
        etYear = (EditText) findViewById(R.id.etYear);
        etMake = (EditText) findViewById(R.id.etMake);
        etModel = (EditText) findViewById(R.id.etModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSave:
                mPresenter.saveCar();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getYear() {
        return etYear.getText().toString();
    }

    @Override
    public String getMake() {
        return etMake.getText().toString();
    }

    @Override
    public String getModel() {
        return etModel.getText().toString();
    }

    @Override
    public void showErrorSaveCar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessSaveCar(Car carResponse) {
        Intent intent = new Intent();
        intent.putExtra(Const.Extra.DATA, carResponse);
        setResult(RESULT_OK, intent);
        finish();
    }
}
