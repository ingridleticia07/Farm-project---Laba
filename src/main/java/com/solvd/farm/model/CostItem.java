package com.solvd.farm.model;

public abstract class CostItem extends FarmItem {
    public CostItem(String name) {
        super(name);
    }

    public abstract double calculateCost();
}
