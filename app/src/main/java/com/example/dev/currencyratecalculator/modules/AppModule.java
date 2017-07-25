package com.example.dev.currencyratecalculator.modules;

import android.content.Context;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.managers.ApiManager;
import com.example.dev.currencyratecalculator.managers.DatabaseManager;
import com.example.dev.currencyratecalculator.model.DaoMaster;
import com.example.dev.currencyratecalculator.model.DaoSession;
import com.example.dev.currencyratecalculator.views.MainActivity;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.dev.currencyratecalculator.utils.Constants.BASE_URL;

/**
 * Created by DEV on 24.07.2017.
 */
@Module
public class AppModule {
    private App app;
    private DaoSession daoSession;

    public AppModule(App app) {
        this.app = app;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(app, "currency-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    @Provides
    public App getApp() {
        return app;
    }

    @Provides
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(app, "currency-db");
            Database db = helper.getWritableDb();
            daoSession = new DaoMaster(db).newSession();
        }
        return daoSession;
    }

    @Provides
    @Singleton
    public DatabaseManager getDatabaseManager() {
        return new DatabaseManager(getApp().getApplicationContext());
    }

    @Provides
    @Singleton
    public ApiManager getApiManager() {
        return new ApiManager(getApp().getApplicationContext());
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
