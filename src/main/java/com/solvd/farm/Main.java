package com.solvd.farm;

import com.solvd.farm.enums.AnimalType;
import com.solvd.farm.enums.ProductType;
import com.solvd.farm.enums.SeasonType;
import com.solvd.farm.exception.InsufficientFundsException;
import com.solvd.farm.exception.InsufficientResourcesException;
import com.solvd.farm.exception.NoProfitException;
import com.solvd.farm.interfaces.Costable;
import com.solvd.farm.interfaces.Feedable;
import com.solvd.farm.interfaces.Maintainable;
import com.solvd.farm.interfaces.Sellable;
import com.solvd.farm.model.*;
import com.solvd.farm.util.ReportGenerator;
import com.solvd.farm.util.Storage;

import com.solvd.farm.util.TextAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Farmer farmer = new Farmer("John", 100000);

        Farm farm = new Farm("Orange County", 100.5, "Canadá", farmer);

        Crop corn = new Crop("Corn", 30, 200);
        Crop wheat = new Crop("Wheat", 40, 300);
        Storage<Crop> cropStorage = new Storage<>();
        cropStorage.add(corn);
        cropStorage.add(wheat);

        Set<Crop> cropSet = new HashSet<>();
        cropSet.add(corn);
        cropSet.add(wheat);


        Animal chicken = new Animal("Chicken", 40, 2, AnimalType.CHICKEN);
        Animal pig = new Animal("Pig", 12, 2, AnimalType.PIG);
        Animal cow = new Animal("Cow", 30, 4,  AnimalType.COW);
        Storage<Animal> animalStorage = new Storage<>();
        animalStorage.add(cow);
        animalStorage.add(pig);
        animalStorage.add(chicken);

        Queue<Animal> feedingQueue = new LinkedList<>();
        feedingQueue.add(cow);
        feedingQueue.add(pig);
        feedingQueue.add(chicken);


        Tool shovel = new Tool("Shovel", 15, 5);
        Tool tractor = new Tool("Tractor", 1000, 1);

        Deque<Tool> toolsDeque = new ArrayDeque<>();
        toolsDeque.add(shovel);
        toolsDeque.add(tractor);


        FoodSupply animalFeed = new FoodSupply("Animal Feed", 30000, 0.8);
        FoodSupply grainStorage = new FoodSupply("Grain", 900, 1.5);
        Storage<Costable> foodStorage = new Storage<>();
        foodStorage.add(animalFeed);
        foodStorage.add(grainStorage);

        Product eggs = new Product("Eggs", 10, 500, ProductType.EGGS);
        Product milk = new Product("Milk", 3, 250, ProductType.MILK);
        Product pork = new Product("Pork", 5, 100, ProductType.PORK);
        Storage<Sellable> productStorage = new Storage<>();
        productStorage.add(milk);
        productStorage.add(pork);
        productStorage.add(eggs);

        Map<String, Product> productsMap = new HashMap<>();

        productsMap.put("eggs", eggs);
        productsMap.put("milk", milk);
        productsMap.put("pork", pork);


        Season autumn = new Season(SeasonType.AUTUMN, 120);

        Expense fertilizer = new Expense("Fertilizer", 400);
        Expense equipmentRepair = new Expense("Equipment Repair", 250);
        Storage<Maintainable>  maintainableStorage = new Storage<>();
        maintainableStorage.add(shovel);
        maintainableStorage.add(tractor);
        maintainableStorage.add(fertilizer);
        maintainableStorage.add(equipmentRepair);

        Harvest cornHarvest = new Harvest("Corn", 1200, 2);
        Harvest wheatHarvest = new Harvest("Wheat", 900, 3);
        Storage<Sellable> harvestStorage = new Storage<>();
        harvestStorage.add(cornHarvest);
        harvestStorage.add(wheatHarvest);

        Costable[] crops = cropStorage.getAll().toArray(new Costable[0]);
        Costable[] foodSupplies = foodStorage.getAll().toArray(new Costable[0]);
        Feedable[] animals = animalStorage.getAll().toArray(new Feedable[0]);
        Maintainable[] maintainables = maintainableStorage.getAll().toArray(new Maintainable[0]);
        Sellable[] products = productStorage.getAll().toArray(new Sellable[0]);
        Sellable[] harvests = harvestStorage.getAll().toArray(new Sellable[0]);

        logger.info(farm.generateReport());
        ReportGenerator<Crop> cropReport = new ReportGenerator<>();
        logger.info("===CROPS===");
        cropReport.print(cropStorage.getAll());

        ReportGenerator<Animal> animalReport = new ReportGenerator<>();
        logger.info("===ANIMALS===");
        animalReport.print(animalStorage.getAll());

        ReportGenerator<Sellable> sellableReport = new ReportGenerator<>();
        logger.info("===SELLABLES===");
        sellableReport.print(productStorage.getAll());
        sellableReport.print(harvestStorage.getAll());

        try {
            farm.processSeason(
                    autumn,
                    crops,
                    foodSupplies,
                    animals,
                    animalFeed,
                    maintainables,
                    products,
                    harvests
            );

            logger.info("Season processed successfully!");
            logger.info("Remaining money: {}", farmer.getMoney());

        } catch (InsufficientResourcesException e) {
            logger.error("Resource error: {}", e.getMessage());

        } catch (InsufficientFundsException e) {
            logger.error("Financial error: {}", e.getMessage());

        } catch (NoProfitException e) {
            logger.warn("Warning: {}", e.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
        }

        TextAnalyzer.analyze("input.txt", "output.txt");
    }

}
