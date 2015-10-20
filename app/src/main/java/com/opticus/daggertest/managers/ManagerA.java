package com.opticus.daggertest.managers;

import android.content.Context;
import android.util.Log;

import com.opticus.daggertest.di.scope.PerActivity;

import javax.inject.Inject;

@PerActivity
public class ManagerA {
    public Context context;

    @Inject
    public ManagerA(Context context) {
        this.context = context;
    }

    @Inject
    void init(Context context) {
        Log.i("GTAG", "method injection");
    }
}
