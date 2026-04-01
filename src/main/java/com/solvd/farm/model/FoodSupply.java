package com.solvd.farm.model;

import com.solvd.farm.interfaces.Costable;

public class FoodSupply extends CostItem implements Costable {
    private int amount;
    private double costPerUnit;

    public FoodSupply(String name, int amount,  double costPerUnit) {
        super(name);
        this.amount = amount;
        this.costPerUnit = costPerUnit;
    }
    @Override
    public double calculateCost(){
        return costPerUnit * amount;
    }

    public int getAmount() {
        return amount;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }
}
