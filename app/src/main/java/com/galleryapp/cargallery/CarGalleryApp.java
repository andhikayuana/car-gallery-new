package com.galleryapp.cargallery;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class CarGalleryApp extends Application {

    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initStetho();
    }

    private void initStetho() {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this);
    }
}
