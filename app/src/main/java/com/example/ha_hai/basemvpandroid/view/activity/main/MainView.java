package com.example.ha_hai.basemvpandroid.view.activity.main;

import com.example.ha_hai.basemvpandroid.baseapp.BaseView;
import com.example.ha_hai.basemvpandroid.data.remote.model.weather.WeatherPojo;


public interface MainView extends BaseView {

    void showWeather(WeatherPojo weatherPojo);

    void showProgress();

    void hideProgress();
}