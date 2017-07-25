package com.example.dev.currencyratecalculator.managers;

import android.content.Context;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.model.DaoSession;
import com.example.dev.currencyratecalculator.model.ExchangeHistory;
import com.example.dev.currencyratecalculator.model.ExchangeHistoryDao;
import com.example.dev.currencyratecalculator.utils.Constants;

import javax.inject.Inject;

/**
 * Created by DEV on 24.07.2017.
 */

public class DatabaseManager {
    @Inject
    DaoSession daoSession;
    private ExchangeHistoryDao exchangeHistoryDao;
    private Context context;

    @Inject
    public DatabaseManager(Context context) {
        this.context = context;
        ((App) context.getApplicationContext()).getAppComponent().inject(this);
        exchangeHistoryDao = daoSession.getExchangeHistoryDao();
    }

    public int insertToHistory(ExchangeHistory exchangeHistory) {
        exchangeHistoryDao.insertOrReplace(exchangeHistory);
        return Constants.SAVED_SUCCESSFUL;
    }
}
