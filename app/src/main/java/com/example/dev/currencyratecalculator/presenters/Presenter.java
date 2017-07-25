package com.example.dev.currencyratecalculator.presenters;

/**
 * Created by DEV on 24.07.2017.
 */

public interface Presenter {
    void getRates();
    void calculate(double first, double second);
}
