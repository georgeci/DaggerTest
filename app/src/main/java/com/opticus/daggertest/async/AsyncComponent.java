package com.opticus.daggertest.async;

import com.google.common.util.concurrent.ListenableFuture;
import com.opticus.daggertest.managers.HugeManager;

import dagger.producers.ProductionComponent;

@ProductionComponent(modules = AsyncModule.class)
public interface AsyncComponent {
    ListenableFuture<HugeManager> hugeManager();
}
