package com.opticus.daggertest.di;

import com.opticus.daggertest.SecondActivity;

import dagger.Module;

@Module(includes = BusModule.class)
public class SecondActModule {
    private SecondActivity activity;

    public SecondActModule(SecondActivity activity) {
        this.activity = activity;
    }
}
