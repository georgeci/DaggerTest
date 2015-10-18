package com.opticus.daggertest;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.opticus.daggertest.di.ActModule;
import com.opticus.daggertest.di.DaggerMainActComponent;
import com.opticus.daggertest.di.HasComponent;
import com.opticus.daggertest.di.MainActComponent;
import com.opticus.daggertest.managers.ManagerA;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements HasComponent<MainActComponent> {

    MainActComponent actComponent;

    @Inject
    Bus bus;
    @Inject
    ManagerA managerA;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("GTAG", "mAct bus: " + (bus == null ? "null" : bus.hashCode()));
        Log.i("GTAG", "mAct managerA: " + (managerA == null ? "null" : ("" + managerA.hashCode() + (managerA.context == null))));
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
