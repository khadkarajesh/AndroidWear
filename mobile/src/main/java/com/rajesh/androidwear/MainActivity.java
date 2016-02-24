package com.rajesh.androidwear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rajesh.wearnotification.NotificationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToWearNotification();
    }

    private void navigateToWearNotification() {
        startActivity(new Intent(this, NotificationActivity.class));
        finish();
    }


}
