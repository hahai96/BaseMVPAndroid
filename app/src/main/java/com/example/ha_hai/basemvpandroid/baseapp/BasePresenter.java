package com.example.ha_hai.basemvpandroid.baseapp;

import com.example.ha_hai.basemvpandroid.baseapp.BaseView;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}