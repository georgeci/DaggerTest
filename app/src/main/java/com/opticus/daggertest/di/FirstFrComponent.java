package com.opticus.daggertest.di;

import android.content.Context;

import com.opticus.daggertest.FirstFragment;
import com.opticus.daggertest.ManagerA;
import com.opticus.daggertest.di.scope.PerActivity;
import com.opticus.daggertest.di.scope.PerFragment;
import com.squareup.otto.Bus;

import dagger.Component;

@PerFragment
@Component(dependencies = {FirstFrComponent.HasFirstFrDepends.class})
public interface FirstFrComponent {
    void inject(FirstFragment fragment);

    @PerActivity
    @Component(modules = {BusModule.class}, dependencies = AppComponent.class)
    interface HasFirstFrDepends {
        Bus bus();

        ManagerA managerA();

        Context context();
    }
}
