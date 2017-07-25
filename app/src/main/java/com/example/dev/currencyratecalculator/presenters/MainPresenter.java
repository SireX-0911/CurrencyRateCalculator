package com.example.dev.currencyratecalculator.presenters;

import android.content.Context;
import android.util.Log;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.managers.ApiManager;
import com.example.dev.currencyratecalculator.model.Currency;
import com.example.dev.currencyratecalculator.model.Rate;
import com.example.dev.currencyratecalculator.views.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by DEV on 24.07.2017.
 */

public class MainPresenter implements Presenter {

    private final MainView mainView;
    @Inject
    ApiManager apiManager;
    private Context context;

    public MainPresenter(MainView mainView, Context context) {
        this.context = context;
        this.mainView = mainView;
        ((App) context.getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public void getRates() {
        final List<Rate> rates = new ArrayList<>();
        apiManager.getRate().subscribe(new Observer<Currency>() {
            @Override
            public void onCompleted() {
                Log.d("rate", "complete");
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("rate", throwable.getMessage());
            }

            @Override
            public void onNext(Currency currency) {
                Log.d("rate", currency.getBase());
                Log.d("rate", currency.getDate());
                rates.add(currency.getRates());
                Log.d("rate", rates.get(0).getCurrency());
                mainView.getCurrencyRate(rates);
            }
        });

    }

    @Override
    public void calculate(double first, double second) {
        mainView.showResult(first * second);
    }
}
