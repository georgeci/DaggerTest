package com.opticus.daggertest.di;

import com.opticus.daggertest.SecondFragment;
import com.opticus.daggertest.di.scope.PerFragment;

import dagger.Subcomponent;


@PerFragment
@Subcomponent(modules = {ManagerBModule.class})
public interface SecondFrComponent {
    void inject(SecondFragment fragment);

    interface PlusComponent {
        SecondFrComponent plusSecondFrComponent();
    }
}
