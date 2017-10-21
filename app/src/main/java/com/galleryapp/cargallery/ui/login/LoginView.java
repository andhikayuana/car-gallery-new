package com.galleryapp.cargallery.ui.login;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public interface LoginView {
    void gotoHome();

    String getUsername();

    String getPassword();

    void showErrorFailedLogin();
}
