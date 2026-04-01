package com.solvd.farm.model;

public abstract class FarmItem {
    protected String name;

    public FarmItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
