package com.opticus.daggertest.async;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.opticus.daggertest.managers.HugeManager;

import dagger.producers.ProducerModule;
import dagger.producers.Produces;

@ProducerModule
public class AsyncModule {
    @Produces
    ListenableFuture<HugeManager> produceHugeManager() {
        return Futures.immediateFuture(new HugeManager());
    }
}
