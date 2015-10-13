package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;

import com.opticus.daggertest.di.DaggerSecondActComponent;
import com.opticus.daggertest.di.HasComponent;
import com.opticus.daggertest.di.SecondActComponent;
import com.opticus.daggertest.di.SecondActModule;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class SecondActivity extends BaseActivity implements HasComponent<SecondActComponent> {

    @Inject
    Bus bus;
    private SecondActComponent component;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        component = DaggerSecondActComponent.builder().appComponent(getAppComponent()).secondActModule(new SecondActModule(this)).build();
        component.inject(this);
        Log.i("GTAG", "sAct bus: " + (bus == null ? "null" : bus.hashCode()));
    }

    @Override
    public SecondActComponent getComponent() {
        return component;
    }
}
