package com.app.activity;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {


    Button show_notification;

    //Notification channel
    //Notification builder
    //Notification manager

    private static final String CHANNEL_ID="Channel id";
    private static final String CHANNEL_NAME="Channel name";
    private static final String CHANNEL_DESCRIPTION="Channel description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if and only id android version is orio and above then we have to create Channel

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        show_notification=findViewById(R.id.show_notification);
        show_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotification();
            }
        });


//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                NotificationChannel channel = new NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
//                NotificationManager manager = getSystemService(NotificationManager.class);
//                manager.createNotificationChannel(channel);
//            }
//        }
//
//        FirebaseMessaging.getInstance().subscribeToTopic("general")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        String msg = "Successful";
//                        if (!task.isSuccessful()) {
//                            msg = "Faild";
//                        }
//                        Toast.makeText(MainActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    public void displayNotification(){
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Hurry| Its working")
                .setContentText("This is first notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //Notification manage
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(1,mBuilder.build());
    }

}
