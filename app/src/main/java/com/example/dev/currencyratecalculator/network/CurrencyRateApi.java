package com.example.dev.currencyratecalculator.network;

import com.example.dev.currencyratecalculator.model.Currency;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by DEV on 24.07.2017.
 */

public interface CurrencyRateApi {
    @GET("latest?symbols=USD")
    Observable<Currency> getRate();
}
