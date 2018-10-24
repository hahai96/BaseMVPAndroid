package com.example.ha_hai.basemvpandroid.view.fragment.detail;

import com.example.ha_hai.basemvpandroid.baseapp.BaseView;
import com.example.ha_hai.basemvpandroid.data.remote.model.forecast.Forecast;

public interface DetailView extends BaseView {

    void showForecast(Forecast forecast);

}