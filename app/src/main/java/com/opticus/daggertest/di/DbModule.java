package com.opticus.daggertest.di;

import android.content.Context;

import com.opticus.daggertest.DbHelper;
import com.opticus.daggertest.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {
    @PerApp
    @Provides
    DbHelper dbHelper(Context context) {
        return new DbHelper(context);
    }
}
