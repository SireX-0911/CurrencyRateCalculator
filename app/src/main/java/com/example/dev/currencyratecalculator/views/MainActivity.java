package com.example.dev.currencyratecalculator.views;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dev.currencyratecalculator.App;
import com.example.dev.currencyratecalculator.R;
import com.example.dev.currencyratecalculator.adapters.HistoryAdapter;
import com.example.dev.currencyratecalculator.managers.ApiManager;
import com.example.dev.currencyratecalculator.managers.DatabaseManager;
import com.example.dev.currencyratecalculator.model.DaoSession;
import com.example.dev.currencyratecalculator.model.ExchangeHistory;
import com.example.dev.currencyratecalculator.model.Rate;
import com.example.dev.currencyratecalculator.presenters.MainPresenter;
import com.jakewharton.rxbinding.view.RxView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    DatabaseManager databaseManager;
    @Inject
    ApiManager apiManager;
    @Inject
    DaoSession daoSession;
    private TextView rate, text, clear, resultUSD, resultEUR;
    private Button num7, num0, num1, num2, num3, num4, num5, num6, num8, num9, get_rate, calc, history;
    private MainPresenter mainPresenter;
    private List<Rate> rateList;
    private long counter = 0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).getAppComponent().inject(this);
        context = this;
        rateList = new ArrayList<>();
        rate = (TextView) findViewById(R.id.rate);
        text = (TextView) findViewById(R.id.text);
        clear = (TextView) findViewById(R.id.clear);
        resultUSD = (TextView) findViewById(R.id.resultUSD);
        resultEUR = (TextView) findViewById(R.id.resultEUR);
        num7 = (Button) findViewById(R.id.num7);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num0 = (Button) findViewById(R.id.num0);
        get_rate = (Button) findViewById(R.id.getRate);
        history = (Button) findViewById(R.id.history);
        calc = (Button) findViewById(R.id.calc);

        mainPresenter = new MainPresenter(this, getApplicationContext());

        Observable<Void> numberSeven = RxView.clicks(num7);
        numberSeven.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "7";
                text.setText(value);
            }
        });
        Observable<Void> numberOne = RxView.clicks(num1);
        numberOne.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "1";
                text.setText(value);
            }
        });
        Observable<Void> numberTwo = RxView.clicks(num2);
        numberTwo.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "2";
                text.setText(value);
            }
        });
        Observable<Void> numberThree = RxView.clicks(num3);
        numberThree.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "3";
                text.setText(value);
            }
        });
        Observable<Void> numberFour = RxView.clicks(num4);
        numberFour.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "4";
                text.setText(value);
            }
        });
        Observable<Void> numberFive = RxView.clicks(num5);
        numberFive.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "5";
                text.setText(value);
            }
        });
        Observable<Void> numberSix = RxView.clicks(num6);
        numberSix.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "6";
                text.setText(value);
            }
        });
        Observable<Void> numberEight = RxView.clicks(num8);
        numberEight.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "8";
                text.setText(value);
            }
        });
        Observable<Void> numberNine = RxView.clicks(num9);
        numberNine.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "9";
                text.setText(value);
            }
        });
        Observable<Void> numberZero = RxView.clicks(num0);
        numberZero.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                String value = text.getText().toString();
                value = value + "0";
                text.setText(value);
            }
        });
        Observable<Void> clearText = RxView.clicks(clear);
        clearText.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                text.setText("");
            }
        });
        Observable<Void> getRate = RxView.clicks(get_rate);
        getRate.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                mainPresenter.getRates();
            }
        });

        final Observable<Void> calculateRate = RxView.clicks(calc);
        calculateRate.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                double euro = Double.valueOf(text.getText().toString());
                double rates = Double.valueOf(rate.getText().toString());
                mainPresenter.calculate(euro, rates);
                counter++;

            }
        });

        Observable<Void> showHistory = RxView.clicks(history);
        showHistory.subscribe(new Action1<Void>() {
            @Override
            public void call(Void x) {
                final Dialog dialog = new Dialog(context);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog, null);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(dialogView);
                TextView back = (TextView) dialogView.findViewById(R.id.back);
                RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.recyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                List<ExchangeHistory> exchangeHistories = daoSession.getExchangeHistoryDao().loadAll();
                HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), exchangeHistories);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int width = displayMetrics.widthPixels;
                dialog.getWindow().setLayout(3 * width / 5, RelativeLayout.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
        });


    }

    @Override
    public void getCurrencyRate(List<Rate> rates) {
        rateList.addAll(rates);
        rate.setText(rateList.get(0).getCurrency());
    }

    @Override
    public void showResult(double result) {
        resultEUR.setText(text.getText().toString());
        resultUSD.setText(result + "");
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        ExchangeHistory exchangeHistory = new ExchangeHistory(counter,formattedDate, Double.valueOf(text.getText().toString()), result, Double.valueOf(rate.getText().toString()));
        databaseManager.insertToHistory(exchangeHistory);
        text.setText("");
    }
}
