package com.galleryapp.cargallery;

import android.app.Application;
import android.content.Context;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class CarGalleryApp extends Application {

    private Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
