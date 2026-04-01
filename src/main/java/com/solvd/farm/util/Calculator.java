package com.solvd.farm.util;

import com.solvd.farm.interfaces.Costable;
import com.solvd.farm.interfaces.Maintainable;
import com.solvd.farm.interfaces.Sellable;

import java.util.List;

public class Calculator<T> {
    public double calculateTotal(List<? extends Costable> items) {
        double total = 0;

        for (Costable item : items) {
            total += item.calculateCost();
        }
        return total;
    }

    public double calculateRevenueTotal(List<? extends Sellable> items) {
        double total = 0;

        for (Sellable item : items) {
            total += item.calculateRevenue();
        }

        return total;
    }

    public double calculateMaintenanceTotal(List<? extends Maintainable> items) {
        double total = 0;

        for (Maintainable item : items) {
            total += item.calculateMaintenanceCost();
        }

        return total;
    }
}
