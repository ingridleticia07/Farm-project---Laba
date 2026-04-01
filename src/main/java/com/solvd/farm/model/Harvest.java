package com.solvd.farm.model;

import com.solvd.farm.interfaces.Sellable;

public class Harvest extends FarmProduct implements Sellable {
    private int totalYield;
    private double pricePerKg;

    public Harvest(String name, int totalYield, double pricePerKg) {
        super(name);
        this.totalYield = totalYield;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString(){
        return "Harvest{name=" + getName() +
                ", totalYield=" + totalYield +" " +
                ", pricePerKg=" + pricePerKg +
                '}';
    }

    @Override
    public double calculateRevenue() {
        return totalYield * pricePerKg;
    }

    public int getTotalYield() {
        return totalYield;
    }

    public void setTotalYield(int totalYield) {
        this.totalYield = totalYield;
    }
}

