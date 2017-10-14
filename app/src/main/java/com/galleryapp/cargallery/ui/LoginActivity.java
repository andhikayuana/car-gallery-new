package com.galleryapp.cargallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galleryapp.cargallery.R;
import com.galleryapp.cargallery.data.local.Session;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        checkLogin();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.equals("jarjit") && password.equals("1234567")) {

            Session.getInstance().setLogin(true);

            checkLogin();

        } else {

            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();

        }
    }

    private void checkLogin() {
        if (Session.getInstance().isLogin()) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
