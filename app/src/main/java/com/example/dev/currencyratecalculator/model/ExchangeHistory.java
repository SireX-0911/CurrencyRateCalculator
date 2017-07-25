package com.example.dev.currencyratecalculator.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by DEV on 24.07.2017.
 */
@Entity(nameInDb = "HISTORY", active = true)
public class ExchangeHistory {

    @Id(autoincrement = true)
    @Property
    private long id;
    @Property
    private String date;
    @Property
    private double amount;
    @Property
    private double amountUSD;
    @Property
    private double rate;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1677200892)
    private transient ExchangeHistoryDao myDao;

    @Generated(hash = 1073103415)
    public ExchangeHistory() {
    }

    @Keep
    public ExchangeHistory(String date, double amount, double amountUSD,
            double rate) {
        this.date = date;
        this.amount = amount;
        this.amountUSD = amountUSD;
        this.rate = rate;
    }

    @Generated(hash = 993293896)
    public ExchangeHistory(long id, String date, double amount, double amountUSD,
            double rate) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.amountUSD = amountUSD;
        this.rate = rate;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmountUSD() {
        return amountUSD;
    }

    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1704916125)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getExchangeHistoryDao() : null;
    }
}
