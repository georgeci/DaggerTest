package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opticus.daggertest.di.DaggerFirstFrComponent;
import com.opticus.daggertest.di.FirstFrComponent;
import com.opticus.daggertest.managers.ManagerA;

import javax.inject.Inject;
import javax.inject.Provider;

public class FirstFragment extends BaseFragment {

    @Inject
    Provider<ManagerA> managerA;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("GTAG", "1 fr bus: " + bus.hashCode());
        Log.i("GTAG", "1 fr managerA: " + managerA.get().hashCode());
        Log.i("GTAG", "1 fr managerA: " + managerA.get().hashCode());
        Log.i("GTAG", "1 fr managerA: " + managerA.get().hashCode());
    }

    @Override
    protected void initDiComponent() {
        FirstFrComponent.HasFirstFrDepends actComponent = getActComponent(FirstFrComponent.HasFirstFrDepends.class);
        DaggerFirstFrComponent.builder()
                .hasFirstFrDepends(actComponent)
                .build()
                .inject(this);
    }
}
