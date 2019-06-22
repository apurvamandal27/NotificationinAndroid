package com.app.activity;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FcmInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String Fcm_token=FirebaseInstanceId.getInstance().getToken();
        Log.d("FM_TOKEN",Fcm_token);
        Toast.makeText(this, ""+Fcm_token, Toast.LENGTH_SHORT).show();
    }
}
