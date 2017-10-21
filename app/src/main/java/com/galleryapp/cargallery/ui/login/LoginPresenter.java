package com.galleryapp.cargallery.ui.login;

import com.galleryapp.cargallery.data.local.Session;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public class LoginPresenter {

    private final LoginView mView;

    public LoginPresenter(LoginView loginView) {
        mView = loginView;
    }

    public void checkLogin() {
        if (Session.getInstance().isLogin()) mView.gotoHome();
    }

    public void login() {
        String username = mView.getUsername();
        String password = mView.getPassword();

        if (username.equals("jarjit") && password.equals("123123")) {
            Session.getInstance().setLogin(true);
            mView.gotoHome();
        } else {
            mView.showErrorFailedLogin();
        }

    }
}
