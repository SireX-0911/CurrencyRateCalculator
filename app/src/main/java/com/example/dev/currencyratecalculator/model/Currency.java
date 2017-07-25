package com.example.dev.currencyratecalculator.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DEV on 24.07.2017.
 */

public class Currency {
    @SerializedName("base")
    private String base;
    @SerializedName("date")
    private String date;
    @SerializedName("rates")
    private Rate rates;

    public Currency(String base, String date, Rate rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rate getRates() {
        return rates;
    }

    public void setRates(Rate rates) {
        this.rates = rates;
    }
}
