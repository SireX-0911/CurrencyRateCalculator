package com.example.dev.currencyratecalculator.managers;

import android.content.Context;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.model.Currency;
import com.example.dev.currencyratecalculator.network.CurrencyRateApi;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.dev.currencyratecalculator.utils.Constants.BASE_URL;

/**
 * Created by DEV on 24.07.2017.
 */

public class ApiManager {
    @Inject
    Retrofit retrofit;
    private CurrencyRateApi rateApi;
    private Context context;

    @Inject
    public ApiManager(Context context) {
        this.context = context;
        ((App) context.getApplicationContext()).getAppComponent().inject(this);
        rateApi = retrofit.create(CurrencyRateApi.class);
    }


    public Observable<Currency> getRate() {
        return rateApi.getRate()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
