package com.rajesh.wearnotification;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btn_show_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });


        findViewById(R.id.btn_show_notification_acton_only_wear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotificationOnlyToWear();
            }
        });

        findViewById(R.id.btn_add_big_view_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBigViewToNotification();
            }
        });
    }

    private void showNotification() {

        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //add action to android wear
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_account_circle_black_24dp, "Archive", pendingIntent1).build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_account_circle_black_24dp)
                .setAutoCancel(true)
                .setContentTitle("Hello")
                .setContentText("It's me tell things")
                .setContentIntent(pendingIntent)
                .addAction(action);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }

    /**
     * It shows notification to only wear
     */
    private void showNotificationOnlyToWear() {
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //add action to android wear
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_account_circle_black_24dp, "Archive", pendingIntent1).build();

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        wearableExtender.addAction(action);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_account_circle_black_24dp)
                .setAutoCancel(true)
                .setContentTitle("Hello")
                .setContentText("It's bird")
                .setContentIntent(pendingIntent)
                .extend(wearableExtender)
                .addAction(action);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }

    private void addBigViewToNotification() {
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //add action to android wear
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_account_circle_black_24dp, "Archive", pendingIntent).build();

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
        wearableExtender.addAction(action);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("this is email from Ganesh");
        bigTextStyle.bigText("your message is to be deliverd in time for your abc");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_account_circle_black_24dp)
                .setAutoCancel(true)
                .setContentTitle("Hello")
                .setContentText("It's bird")
                .setContentIntent(pendingIntent)
                .extend(wearableExtender)
                .addAction(action).setStyle(bigTextStyle);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }
}
