package com.opticus.daggertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.opticus.daggertest.async.AsyncInjectActivity;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void click1(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void click2(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void click3(View view) {
        startActivity(new Intent(this, AsyncInjectActivity.class));
    }
}
