package com.pluralsight.model;

public abstract class Product implements Priceable{

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
