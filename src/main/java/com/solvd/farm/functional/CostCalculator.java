package com.solvd.farm.functional;

@FunctionalInterface
public interface CostCalculator<T> {
    double calculate(T item);
}
