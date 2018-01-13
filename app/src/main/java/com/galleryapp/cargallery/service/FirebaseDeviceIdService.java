package com.galleryapp.cargallery.service;

import android.util.Log;

import com.galleryapp.cargallery.data.local.Session;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * @author yuana <andhikayuana@gmail.com>
 * @since 1/13/18
 */

public class FirebaseDeviceIdService extends FirebaseInstanceIdService {

    private static final String TAG = FirebaseDeviceIdService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        Session.getInstance().saveDeviceToken(refreshedToken);
    }
}
