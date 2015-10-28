package com.opticus.daggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.opticus.daggertest.di.AppComponent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initDiComponent();
        super.onCreate(savedInstanceState);
    }

    abstract protected void initDiComponent();

    protected AppComponent getAppComponent() {
        return ((App) getApplication()).getComponent();
    }

}
