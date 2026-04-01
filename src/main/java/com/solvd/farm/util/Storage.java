package com.solvd.farm.util;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}
