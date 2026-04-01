package com.solvd.farm.model;

import com.solvd.farm.interfaces.Maintainable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Tool extends Resource implements Maintainable {
    private double price;
    private int quantity;

    public Tool(String name, double price, int quantity) {
        super(name);
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateToolCost(){
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Tool{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }

    @Override
    public double calculateMaintenanceCost(){
        return price * quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
