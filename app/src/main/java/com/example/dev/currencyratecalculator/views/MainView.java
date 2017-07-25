package com.example.dev.currencyratecalculator.views;

import com.example.dev.currencyratecalculator.model.Rate;

import java.util.List;

/**
 * Created by DEV on 24.07.2017.
 */

public interface MainView {
    void getCurrencyRate(List<Rate> rates);
    void showResult(double result);
}
