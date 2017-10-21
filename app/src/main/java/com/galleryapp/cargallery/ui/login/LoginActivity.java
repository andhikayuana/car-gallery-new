package com.galleryapp.cargallery.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.ui.home.HomeActivity;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initPresenter();
        mPresenter.checkLogin();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.login();
    }

    @Override
    public void gotoHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showErrorFailedLogin() {
        Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
    }
}
