package com.opticus.daggertest;

import android.app.Application;
import android.util.Log;

import com.opticus.daggertest.di.AppComponent;
import com.opticus.daggertest.di.AppModule;
import com.opticus.daggertest.di.DaggerAppComponent;
import com.opticus.daggertest.di.HasComponent;
import com.opticus.daggertest.managers.DbHelper;

import javax.inject.Inject;

public class App extends Application implements HasComponent<AppComponent> {
    @Inject
    DbHelper dbHelper;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = createComponent();
        component.inject(this);
        Log.i("GTAG", "app db: " + dbHelper.hashCode());
    }

    @Override
    public AppComponent getComponent() {
        return component;
    }

    public AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
