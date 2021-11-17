package com.revature.project0.models;

import com.revature.project0.util.Collections.LinkedList;

import java.util.Objects;

public class Accounts {
    private int id;
    private String name;
    private String type;
    private float balance;
    private String creator;
    private LinkedList<String> accessors;

    public Accounts(){
        super();
    }

    public Accounts(String type, String name, String creator){
        this.type = type;
        this. name = name;
        this.balance = 1.00f;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LinkedList<String> getAccessors() {
        return accessors;
    }

    public void setAccessors(LinkedList<String> accessors) {
        this.accessors = accessors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id
                && Float.compare(accounts.balance, balance) == 0
                && name.equals(accounts.name)
                && type.equals(accounts.type)
                && creator.equals(accounts.creator)
                && accessors.equals(accounts.accessors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, balance, creator, accessors);
    }

    @Override
    public String toString(){
        return "Account ID: " + this.getId() + " , Account Name: " + this.getName() + " , Account Type: " +
                this.getType() + " , Account Balance: " + this.getBalance();
    }
}
