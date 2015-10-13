package com.opticus.daggertest.di;

import com.opticus.daggertest.BaseActivity;

import dagger.Module;

@Module()
public class ActModule {

    private BaseActivity activity;

    public ActModule(BaseActivity activity) {
        this.activity = activity;
    }

}
