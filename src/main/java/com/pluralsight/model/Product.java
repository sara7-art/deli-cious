package com.pluralsight.model;

public abstract class Product implements Priceable {

    // Encapsulation
    private String name;


    // Constructor

    public Product(String name) {
        this.name = name;
    }


    // Getter

    public String getName() {
        return name;
    }


    // Setter

    public void setName(String name) {
        this.name = name;
    }
}