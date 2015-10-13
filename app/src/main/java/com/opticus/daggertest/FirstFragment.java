package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opticus.daggertest.di.DaggerFirstFrComponent;
import com.opticus.daggertest.di.FirstFrComponent;
import com.opticus.daggertest.di.HasComponent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class FirstFragment extends BaseFragment {
    @Inject
    Bus bus;

    @Inject
    ManagerA managerA;

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
        HasComponent<FirstFrComponent.HasFirstFrDepends> act = (HasComponent<FirstFrComponent.HasFirstFrDepends>) getActivity();
        DaggerFirstFrComponent.builder().hasFirstFrDepends(act.getComponent()).build().inject(this);
        Log.i("GTAG", "1 fr bus: " + (bus == null ? "null" : bus.hashCode()));
        Log.i("GTAG", "1 fr managerA: " + (managerA == null ? "null" : managerA.hashCode()));
    }
}
