package com.solvd.farm.model;

import com.solvd.farm.interfaces.Sellable;

public class Product extends FarmProduct implements Sellable {
    private double price;
    private int quantity;

    public  Product(String name, double price, int quantity) {
        super(name);
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calculateRevenue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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
