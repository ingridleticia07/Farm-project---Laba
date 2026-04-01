package com.solvd.farm.model;

import com.solvd.farm.exception.InsufficientFundsException;
import com.solvd.farm.exception.InsufficientResourcesException;
import com.solvd.farm.exception.NoProfitException;
import com.solvd.farm.interfaces.*;
import com.solvd.farm.model.Farmer;
import com.solvd.farm.model.FoodSupply;
import com.solvd.farm.model.Season;
import com.solvd.farm.util.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Farm implements Reportable {

    private static final Logger logger = LogManager.getLogger(Farm.class);

    private String name;
    private double size;
    private String location;
    private Farmer farmer;

    public Farm(String name, double size, String location, Farmer farmer) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Farm{" + "name=" + name + ", size=" + size + ", location=" + location + '}';
    }

    @Override
    public String generateReport() {
        return "==========FARM REPORT==========\n" +
                "Name: " + name + "\n" +
                "Location: " + location + "\n" +
                "Size: " + size + "\n" +
                "Farmer: " + farmer.getName();
    }

    public void processSeason(Season season,
                              Costable[] crops,
                              Costable[] foodSupplies,
                              Feedable[] animals,
                              FoodSupply animalFeed,
                              Maintainable[] maintainables,
                              Sellable[] products,
                              Sellable[] harvests)
            throws InsufficientFundsException, InsufficientResourcesException, NoProfitException {

        double totalCropCost = 0;
        double totalFoodSupplyCost = 0;
        double totalMaintenance = 0;
        double totalFoodCost = 0;

        logger.info("===== Processing Season =====");

        Calculator<Costable> calculator = new Calculator<>();
        Calculator<Sellable> revenueCalculator = new Calculator<>();
        Calculator<Maintainable> maintainerCalculator = new Calculator<>();

        totalCropCost = calculator.calculateTotal(Arrays.asList(crops));

//        for (Costable item : crops) {
//            totalCropCost += item.calculateCost();
//        }
        logger.info("Crop cost: {}", totalCropCost);

//        for (Costable item : foodSupplies) {
//            totalFoodSupplyCost += item.calculateCost();
//        }
        totalFoodSupplyCost = calculator.calculateTotal(Arrays.asList(foodSupplies));
        logger.info("Food Supply cost: {}", totalFoodSupplyCost);

        double totalFoodNeeded = 0;

        for (Feedable animal : animals) {
            double foodNeeded = animal.calculateFoodNeeded(season.getDuration());
            totalFoodNeeded += foodNeeded;
            totalFoodCost += foodNeeded * animalFeed.getCostPerUnit();
        }

        if (totalFoodNeeded > animalFeed.getAmount()) {
            throw new InsufficientResourcesException("Not enough food!");
        }

        logger.info("Animal food cost: {}", totalFoodCost);

//        for (Maintainable item : maintainables) {
//            totalMaintenance += item.calculateMaintenanceCost();
//        }
        totalMaintenance = calculator.calculateMaintenanceTotal(Arrays.asList(maintainables));
        logger.info("Maintenance cost: {}", totalMaintenance);

        double productRevenue = 0;
//        for (Sellable item : products) {
//            productRevenue += item.calculateRevenue();
//        }
        productRevenue = calculator.calculateRevenueTotal(Arrays.asList(products));
        logger.info("Product revenue: {}", productRevenue);

        double harvestRevenue = 0;
//        for (Sellable item : harvests) {
//            harvestRevenue += item.calculateRevenue();
//        }
        harvestRevenue = calculator.calculateRevenueTotal(Arrays.asList(harvests));
        logger.info("Harvest revenue: {}", harvestRevenue);

        double totalRevenue = productRevenue + harvestRevenue;

        double totalCost = totalCropCost + totalFoodSupplyCost + totalFoodCost + totalMaintenance;

        logger.info("Total cost: {}", totalCost);
        logger.info("Total revenue: {}", totalRevenue);

        double profit = totalRevenue - totalCost;

        if (farmer.getMoney() < totalCost) {
            throw new InsufficientFundsException(
                    "Not enough money! Required: " + totalCost + ", Available: " + farmer.getMoney()
            );
        }

        if (profit <= 0) {
            throw new NoProfitException("No profit this season!");
        }

            farmer.spendMoney(totalCost);
            farmer.earnMoney(totalRevenue);

            logger.info("Farmer final balance: {}", farmer.getMoney());
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}

