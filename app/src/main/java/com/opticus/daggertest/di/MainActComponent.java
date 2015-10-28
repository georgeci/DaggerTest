package com.opticus.daggertest.di;

import com.opticus.daggertest.MainActivity;
import com.opticus.daggertest.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = {ActModule.class, BusModule.class}, dependencies = AppComponent.class)
public interface MainActComponent extends
        SecondFrComponent.PlusComponent, // SubComponent way
        FirstFrComponent.HasFirstFrDepends {//Depends component way

    void inject(MainActivity activity);
}
