package com.example.dev.currencyratecalculator.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DEV on 24.07.2017.
 */

public class Rate {
    @SerializedName("USD")
    @Expose
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Rate(String currency) {
        this.currency = currency;

    }
}
