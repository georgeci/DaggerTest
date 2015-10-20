package com.opticus.daggertest.di;

import android.content.Context;

import com.opticus.daggertest.FirstFragment;
import com.opticus.daggertest.di.scope.PerFragment;
import com.opticus.daggertest.managers.ManagerA;
import com.squareup.otto.Bus;

import dagger.Component;

@PerFragment
@Component(dependencies = {FirstFrComponent.HasFirstFrDepends.class})
public interface FirstFrComponent {
    void inject(FirstFragment fragment);

    interface HasFirstFrDepends {
        Bus bus();

        Context context();

        ManagerA managerA();


    }
}
