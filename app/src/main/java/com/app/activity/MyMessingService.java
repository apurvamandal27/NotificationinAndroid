package com.app.activity;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title, String message) {
        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_collasped);
        RemoteViews expendedView = new RemoteViews(getPackageName(), R.layout.notification_expended);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyNotification")
                .setContentTitle("student Care ")
                .setSmallIcon(R.drawable.notification)
                .setAutoCancel(true)
                .setContentText(message);
//        builder.setCustomContentView(collapsedView);
//        builder.setCustomBigContentView(expendedView);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(100, builder.build());
    }
}
