package com.opticus.daggertest.managers;

import android.content.Context;

import javax.inject.Inject;

public class ManagerA {
    public Context context;

    @Inject
    public ManagerA(Context context) {
        this.context = context;
    }
}
