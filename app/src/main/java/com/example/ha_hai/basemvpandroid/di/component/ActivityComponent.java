package com.example.ha_hai.basemvpandroid.di.component;

import com.example.ha_hai.basemvpandroid.di.ActivityScope;
import com.example.ha_hai.basemvpandroid.view.activity.main.MainActivity;
import com.example.ha_hai.basemvpandroid.view.activity.settings.SettingsActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(SettingsActivity settingsActivity);
}