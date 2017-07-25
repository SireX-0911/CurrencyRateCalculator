package com.example.dev.currencyratecalculator;

import android.app.Application;

import com.example.dev.currencyratecalculator.components.AppComponent;
import com.example.dev.currencyratecalculator.components.DaggerAppComponent;
import com.example.dev.currencyratecalculator.model.DaoSession;
import com.example.dev.currencyratecalculator.modules.AppModule;

import javax.inject.Inject;

/**
 * Created by DEV on 24.07.2017.
 */

public class App extends Application {
    private AppComponent appComponent;
    @Inject
    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
