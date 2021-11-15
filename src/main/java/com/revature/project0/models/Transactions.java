package com.revature.project0.models;

import java.util.Objects;

public class Transactions {
    private int id;
    private String sender;
    private String reciever;
    private String sender_account;
    private String reciever_account;
    private float amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSender_account() {
        return sender_account;
    }

    public void setSender_account(String sender_account) {
        this.sender_account = sender_account;
    }

    public String getReciever_account() {
        return reciever_account;
    }

    public void setReciever_account(String reciever_account) {
        this.reciever_account = reciever_account;
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
        Transactions transaction = (Transactions) o;
        return id == transaction.id
                && Float.compare(transaction.amount, amount) == 0
                && Objects.equals(sender, transaction.sender)
                && Objects.equals(reciever, transaction.reciever)
                && Objects.equals(sender_account, transaction.sender_account)
                && Objects.equals(reciever_account, transaction.reciever_account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, reciever, sender_account, reciever_account, amount);
    }
}
