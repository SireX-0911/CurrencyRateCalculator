package com.example.dev.currencyratecalculator.presenters;

/**
 * Created by DEV on 24.07.2017.
 */

public abstract class Presenter {
    abstract void getRates();
    abstract void calculate(double first, double second);
}
