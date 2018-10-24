package com.example.ha_hai.basemvpandroid.view.activity.main;

import android.content.Context;


import com.example.ha_hai.basemvpandroid.BaseApplication;
import com.example.ha_hai.basemvpandroid.R;
import com.example.ha_hai.basemvpandroid.baseapp.BasePresenter;
import com.example.ha_hai.basemvpandroid.data.remote.APIService;
import com.example.ha_hai.basemvpandroid.data.remote.model.weather.WeatherPojo;
import com.example.ha_hai.basemvpandroid.events.MessagesEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class MainPresenter implements BasePresenter<MainView> {

    @Inject
    APIService mAPIService;
    @Inject
    EventBus mEventBus;
    private MainView mMainView;
    private Subscription mSubscription;
    private WeatherPojo mWeatherPojo;

    @Inject
    public MainPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    private static boolean isHttp404(Throwable error) {
        return error instanceof HttpException && ((HttpException) error).code() == 404;
    }

    @Override
    public void attachView(MainView view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        mMainView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadWeather(String from_where) {

        String weatherFromWhere = from_where.trim();
        if (weatherFromWhere.isEmpty()) return;

        mMainView.showProgress();
        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mMainView.getContext());

        mSubscription = mAPIService.getWeatherForCity(weatherFromWhere, "metric")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<WeatherPojo>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Weather loaded " + mWeatherPojo);
                        mMainView.showWeather(mWeatherPojo);
                        mMainView.hideProgress();
                        mMainView.showWeather(mWeatherPojo);
                    }

                    @Override
                    public void onError(Throwable error) {
                        if (isHttp404(error)) {
                            mEventBus.post(new MessagesEvent(false, baseApplication.getString(R.string.error_not_found)));
                        } else {
                            mEventBus.post(new MessagesEvent(false, baseApplication.getString(R.string.error_loading_weather)));
                        }

                        mMainView.hideProgress();
                    }

                    @Override
                    public void onNext(WeatherPojo weatherPojo) {
                        mWeatherPojo = weatherPojo;
                    }
                });
    }
}