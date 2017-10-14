package com.galleryapp.cargallery.data.local;


import com.galleryapp.cargallery.util.Const;
import com.galleryapp.cargallery.util.SharedPrefUtil;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/14/17
 */

public class Session {

    private static Session ourInstance;

    private Session() {
    }

    public static Session getInstance() {
        if (ourInstance == null) ourInstance = new Session();
        return ourInstance;
    }

    public boolean isLogin() {
        return SharedPrefUtil.getBoolean(Const.Pref.IS_LOGIN);
    }

    public void setLogin(boolean isLogin) {
        SharedPrefUtil.saveBoolean(Const.Pref.IS_LOGIN, isLogin);
    }
}
