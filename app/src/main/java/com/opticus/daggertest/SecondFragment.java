package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opticus.daggertest.di.HasComponent;
import com.opticus.daggertest.di.SecondFrComponent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class SecondFragment extends BaseFragment {

    @Inject
    DbHelper dbHelper;
    @Inject
    Bus bus;
    @Inject
    ManagerB managerB;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HasComponent<SecondFrComponent.PlusComponent> act = (HasComponent<SecondFrComponent.PlusComponent>) getActivity();
        SecondFrComponent component = act.getComponent().plusSecondFrComponent();
        component.inject(this);
        Log.i("GTAG", "2 fr db: " + (dbHelper == null ? "null" : ("" + dbHelper.hashCode() + (dbHelper.context == null))));
        Log.i("GTAG", "2 fr bus: " + (bus == null ? "null" : bus.hashCode()));
        Log.i("GTAG", "2 fr managerB: " + (managerB == null ? "null" : managerB.hashCode()));
    }


}
