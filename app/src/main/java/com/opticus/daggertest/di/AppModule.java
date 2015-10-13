package com.opticus.daggertest.di;

import android.content.Context;

import com.opticus.daggertest.App;
import com.opticus.daggertest.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

@Module(includes = DbModule.class)
public class AppModule {
    protected final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @PerApp
    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }


}
