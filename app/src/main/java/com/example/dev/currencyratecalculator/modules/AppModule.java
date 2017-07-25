package com.example.dev.currencyratecalculator.modules;

import android.content.Context;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.managers.ApiManager;
import com.example.dev.currencyratecalculator.managers.DatabaseManager;
import com.example.dev.currencyratecalculator.model.DaoMaster;
import com.example.dev.currencyratecalculator.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DEV on 24.07.2017.
 */
@Module
public class AppModule {
    private DaoSession daoSession;
    private Context context;

    public AppModule(Context context) {
        this.context = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "currency-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    @Provides
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "currency-db");
            Database db = helper.getWritableDb();
            daoSession = new DaoMaster(db).newSession();
        }
        return daoSession;
    }

    @Provides
    @Singleton
    public DatabaseManager getDatabaseManager() {
        return new DatabaseManager(context);
    }

    @Provides
    @Singleton
    public ApiManager getApiManager() {
        return new ApiManager(context);
    }
}
