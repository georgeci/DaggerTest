package com.opticus.daggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.opticus.daggertest.di.AppComponent;

/**
 * Created by opticus on 09.10.15.
 */
public class BaseActivity extends AppCompatActivity {
//    protected ActComponent component;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        component = DaggerActComponent.builder().actModule(new ActModule(this)).build();
    }

    protected AppComponent getAppComponent() {
        return ((App) getApplication()).getComponent();
    }

}
