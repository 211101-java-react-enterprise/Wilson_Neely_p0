package com.revature.project0.models;

import java.util.Date;
import java.util.Objects;

public class Transactions {
    private int id;
    private int account;
    private float amount;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return id == that.id && account == that.account && Float.compare(that.amount, amount) == 0 && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, amount, date);
    }
}
