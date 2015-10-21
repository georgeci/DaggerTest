package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;

import com.opticus.daggertest.di.ActModule;
import com.opticus.daggertest.di.DaggerMainActComponent;
import com.opticus.daggertest.di.HasComponent;
import com.opticus.daggertest.di.MainActComponent;
import com.opticus.daggertest.managers.ManagerA;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import dagger.Lazy;

public class MainActivity extends BaseActivity implements HasComponent<MainActComponent> {

    MainActComponent actComponent;

    @Inject
    Lazy<ManagerA> managerA;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("GTAG", "mAct bus: " + bus.hashCode());
        Log.i("GTAG", "mAct managerA: " + managerA.get().hashCode());
        Log.i("GTAG", "mAct managerA: " + managerA.get().hashCode());
        Log.i("GTAG", "mAct managerA: " + managerA.get().hashCode());
    }

    @Override
    protected void initDiComponent() {
        actComponent = DaggerMainActComponent
                .builder()
                .appComponent(getAppComponent())
                .actModule(new ActModule(this))
                .build();
        actComponent.inject(this);
    }

    @Override
    public MainActComponent getComponent() {
        return actComponent;
    }
}
