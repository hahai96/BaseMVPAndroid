package com.example.ha_hai.basemvpandroid.di.component;

import com.example.ha_hai.basemvpandroid.BaseApplication;
import com.example.ha_hai.basemvpandroid.data.local.PreferencesHelper;
import com.example.ha_hai.basemvpandroid.data.remote.APIService;
import com.example.ha_hai.basemvpandroid.data.remote.UnauthorisedInterceptor;
import com.example.ha_hai.basemvpandroid.di.module.ApplicationModule;
import com.example.ha_hai.basemvpandroid.view.activity.main.MainPresenter;
import com.example.ha_hai.basemvpandroid.view.fragment.detail.DetailPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainPresenter mainPresenter);

    void inject(DetailPresenter detailPresenter);

    void inject(BaseApplication baseApplication);

    void inject(UnauthorisedInterceptor unauthorisedInterceptor);

    APIService apiService();

    EventBus eventBus();

    PreferencesHelper prefsHelper();

}