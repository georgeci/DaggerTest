package com.opticus.daggertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.opticus.daggertest.di.HasComponent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment {
    @Inject
    Bus bus;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDiComponent();
    }

    abstract protected void initDiComponent();

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    public <T> T getActComponent(Class<T> clazz) {
        Activity activity = getActivity();
        HasComponent<T> has = (HasComponent<T>) activity;
        return has.getComponent();
    }
}
