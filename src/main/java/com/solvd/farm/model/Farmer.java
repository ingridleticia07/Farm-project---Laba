package com.solvd.farm.model;

import com.solvd.farm.exception.InsufficientFundsException;
import com.solvd.farm.exception.NoProfitException;

public class Farmer {
    private String name;
    private double money;

    public Farmer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Farmer{" + "name=" + name + ", money=" + money + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void spendMoney(double amount) throws InsufficientFundsException {
        if (amount > money) {
            throw new InsufficientFundsException("Not enough money!");
        }
        money -= amount;
    }

    public void earnMoney(double amount) throws NoProfitException {
        if (amount < 0) {
            throw new NoProfitException("Invalid amount to earn.");
        }

        this.money += amount;
    }
}
