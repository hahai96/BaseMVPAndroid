package com.example.ha_hai.basemvpandroid.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ha_hai.basemvpandroid.BaseApplication;
import com.example.ha_hai.basemvpandroid.di.component.ActivityComponent;
import com.example.ha_hai.basemvpandroid.di.component.DaggerActivityComponent;

public abstract class AppActivity extends AppCompatActivity {

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = DaggerActivityComponent.builder().applicationComponent(getApp().getApplicationComponent()).build();
    }

    protected ActivityComponent getComponent() {
        return mComponent;
    }

    protected BaseApplication getApp() {
        return (BaseApplication) getApplicationContext();
    }

}
