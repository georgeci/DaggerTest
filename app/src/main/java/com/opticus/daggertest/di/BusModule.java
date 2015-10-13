package com.opticus.daggertest.di;

import com.opticus.daggertest.di.scope.PerActivity;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

@Module
public class BusModule {
    @Provides
    @PerActivity
    public Bus provideBus() {
        return new Bus("default");
    }
}
