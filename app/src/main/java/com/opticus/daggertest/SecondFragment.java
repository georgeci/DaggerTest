package com.opticus.daggertest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opticus.daggertest.di.SecondFrComponent;
import com.opticus.daggertest.managers.DbHelper;
import com.opticus.daggertest.managers.ManagerB;

import javax.inject.Inject;

public class SecondFragment extends BaseFragment {

    @Inject
    DbHelper dbHelper;
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
        Log.i("GTAG", "2 fr db: " + dbHelper.hashCode());
        Log.i("GTAG", "2 fr bus: " + bus.hashCode());
        Log.i("GTAG", "2 fr managerB: " + managerB.hashCode());
    }

    @Override
    protected void initDiComponent() {
        SecondFrComponent.PlusComponent actComponent = getActComponent(SecondFrComponent.PlusComponent.class);
        SecondFrComponent component = actComponent.plusSecondFrComponent();
        component.inject(this);
    }


}
