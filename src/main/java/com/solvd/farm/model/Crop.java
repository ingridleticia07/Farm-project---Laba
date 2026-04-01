package com.solvd.farm.model;

import com.solvd.farm.interfaces.Costable;
import com.solvd.farm.model.CostItem;

public class Crop extends CostItem implements Costable {
    private int quantity;
    private double cost;

    public Crop(String name, double cost, int quantity) {
        super(name);
        this.cost = cost;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Crop{name=" +getName()+", cost="+cost+", quantity="+quantity+"}";
    }

    @Override
    public double calculateCost() {
        return cost * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crop)) return false;

        Crop crop = (Crop) o;

        return name.equals(crop.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

}
