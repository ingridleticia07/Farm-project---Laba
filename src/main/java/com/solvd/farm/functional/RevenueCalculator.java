package com.solvd.farm.functional;

@FunctionalInterface
public interface RevenueCalculator<T> {
    double calculate(T item);
}
