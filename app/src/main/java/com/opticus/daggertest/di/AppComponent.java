package com.opticus.daggertest.di;

import android.content.Context;

import com.opticus.daggertest.App;
import com.opticus.daggertest.di.scope.PerApplication;
import com.opticus.daggertest.managers.DbHelper;

import dagger.Component;

@PerApplication
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);

    Context context();

    DbHelper dbHelper();
}
