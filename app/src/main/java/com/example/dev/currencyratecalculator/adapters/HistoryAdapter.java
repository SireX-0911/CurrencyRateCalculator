package com.example.dev.currencyratecalculator.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dev.currencyratecalculator.R;
import com.example.dev.currencyratecalculator.model.DaoSession;
import com.example.dev.currencyratecalculator.model.ExchangeHistory;
import com.example.dev.currencyratecalculator.model.ExchangeHistoryDao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by DEV on 25.07.2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    @Inject
    DaoSession daoSession;
    private Context context;
    List<ExchangeHistory> exchangeHistories;

    public HistoryAdapter(Context context, List<ExchangeHistory> list) {
        this.context = context;
        this.exchangeHistories = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.date.setText(exchangeHistories.get(position).getDate());
        holder.rate.setText(exchangeHistories.get(position).getRate() + "");
        holder.euro.setText(exchangeHistories.get(position).getAmount() + "");
        holder.usd.setText(exchangeHistories.get(position).getAmountUSD() + "");
    }

    @Override
    public int getItemCount() {
        return exchangeHistories.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rate;
        TextView euro;
        TextView usd;
        TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);

            rate = (TextView) itemView.findViewById(R.id.rate);
            euro = (TextView) itemView.findViewById(R.id.euro);
            usd = (TextView) itemView.findViewById(R.id.usd);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
