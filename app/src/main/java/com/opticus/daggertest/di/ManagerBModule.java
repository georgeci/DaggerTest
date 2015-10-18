package com.opticus.daggertest.di;

import com.opticus.daggertest.managers.ManagerB;
import com.opticus.daggertest.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerBModule {
    @PerFragment
    @Provides
    ManagerB provideManagerB() {
        return new ManagerB();
    }
}
