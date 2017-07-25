package com.example.dev.currencyratecalculator.components;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.managers.ApiManager;
import com.example.dev.currencyratecalculator.managers.DatabaseManager;
import com.example.dev.currencyratecalculator.modules.AppModule;
import com.example.dev.currencyratecalculator.presenters.MainPresenter;
import com.example.dev.currencyratecalculator.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by DEV on 24.07.2017.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Retrofit getRetrofit();
    ApiManager getApiManager();
    DatabaseManager getDatabaseManager();

    void inject(App app);
    void inject(MainPresenter mainPresenter);
    void inject(DatabaseManager databaseManager);
    void inject(ApiManager apiManager);
    void inject(MainActivity mainActivity);
}
