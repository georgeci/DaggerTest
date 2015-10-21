package com.opticus.daggertest.managers;

import android.util.Log;

import java.util.concurrent.TimeUnit;

public class HugeManager {
    public HugeManager() {
        Log.i("GTAG", "init huge on: " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
