package com.solvd.farm.model;

import com.solvd.farm.interfaces.Feedable;
import com.solvd.farm.model.BiologicalAsset;
import com.solvd.farm.enums.AnimalType;

public class Animal extends BiologicalAsset implements Feedable {
    private int count;
    private double foodPerDay;
    private AnimalType type;

    public Animal(String name, int count, double foodPerDay, AnimalType type) {
        super(name);
        this.count = count;
        this.foodPerDay = foodPerDay;
        this.type = type;
    }

    public double calculateFoodCost(int days) {
        return foodPerDay * count * days;
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", foodPerDay=" + foodPerDay + "type=" + type + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        return name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public double calculateFoodNeeded(int days) {
        return foodPerDay * count * days;
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getFoodPerDay() {

        return foodPerDay;
    }

    public void setFoodPerDay(double foodPerDay) {
        this.foodPerDay = foodPerDay;
    }
}
