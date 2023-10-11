package com.example.admobopenappad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.google.android.gms.ads.MobileAds;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MobileAds.initialize(this);
        Application application = getApplication();
        ((MyApplication) application).loadAd(this);

        createTimer();
    }

    private void createTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Application application = getApplication();
                ((MyApplication) application).showAdIfAvailable(SplashActivity.this, new MyApplication.OnShowAdCompleteListener() {
                    @Override
                    public void onAdShown() {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        };
        countDownTimer.start();
    }
}