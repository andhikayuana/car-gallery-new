package com.galleryapp.cargallery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.galleryapp.cargallery.CarGalleryApp;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 10/7/17
 */

public class SharedPrefUtil {

    private static SharedPreferences getPref() {
        Context context = CarGalleryApp.getContext();
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveString(String key, String value) {
        getPref().edit().putString(key, value).apply();
    }

    public static String getString(String key) {
        return getPref().getString(key, null);
    }

    public static void saveInt(String key, int value) {
        getPref().edit().putInt(key, value).apply();
    }

    public static int getInt(String key) {
        return getPref().getInt(key, 0);
    }

    public static void saveBoolean(String key, boolean value) {
        getPref().edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key) {
        return getPref().getBoolean(key, false);
    }

    public static void saveLong(String key, Long value) {
        getPref().edit().putLong(key, value).apply();
    }

    public static Long getLong(String key) {
        return getPref().getLong(key, 0);
    }

    public static void saveFloat(String key, float value) {
        getPref().edit().putFloat(key, value).apply();
    }

    public static float getFloat(String key) {
        return getPref().getFloat(key, 0);
    }

    public static void remove(String key) {
        getPref().edit().remove(key).apply();
    }

    public static SharedPreferences.Editor getEditor() {
        return getPref().edit();
    }
}
