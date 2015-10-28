package com.opticus.daggertest.async;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.util.concurrent.ListenableFuture;
import com.opticus.daggertest.R;
import com.opticus.daggertest.managers.HugeManager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class AsyncInjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initDiComponent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_inject);
    }

    protected void initDiComponent() {
        AsyncComponent component = DaggerAsyncComponent
                .builder()
                .asyncModule(new AsyncModule())
                .executor(Executors.newSingleThreadExecutor())
                .build();
        ListenableFuture<HugeManager> future = component.hugeManager();
    }

}
