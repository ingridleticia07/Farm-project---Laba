package com.solvd.farm.model;

import com.solvd.farm.interfaces.Maintainable;

public class Expense implements Maintainable {
    private String description;
    private double cost;

    public Expense(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public double calculateMaintenanceCost(){
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
