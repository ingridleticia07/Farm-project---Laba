package com.solvd.farm.functional;

@FunctionalInterface
public interface FoodCalculator<T> {
    double calculate(T item, int days);
}
