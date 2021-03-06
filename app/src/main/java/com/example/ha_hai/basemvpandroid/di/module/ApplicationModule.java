package com.example.ha_hai.basemvpandroid.di.module;

import com.example.ha_hai.basemvpandroid.BaseApplication;
import com.example.ha_hai.basemvpandroid.data.local.PreferencesHelper;
import com.example.ha_hai.basemvpandroid.data.remote.APIService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final BaseApplication mBaseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.mBaseApplication = baseApplication;
    }

    @Provides
    @Singleton
    public BaseApplication provideApplication() {
        return mBaseApplication;
    }

    @Provides
    @Singleton
    public APIService provideApiService() {
        return APIService.Factory.create(mBaseApplication);
    }

    @Provides
    @Singleton
    public EventBus eventBus() {
        return new EventBus();
    }

    @Provides
    @Singleton
    public PreferencesHelper prefsHelper() {
        return new PreferencesHelper(mBaseApplication);
    }

}