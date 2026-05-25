package com.pluralsight.model;

import java.util.ArrayList;

public class Sandwich extends Product {
    // DATA FIELD//
    private String bread;
    private int size;
    private boolean toasted;

    // ArrayList stores all toppings
    private ArrayList<Topping> toppings;

    public Sandwich(String name, String bread, int size, boolean toasted) {
        super(name);
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;

        toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double calculatePrice() {
        double total = 0;
        if (size == 4) {
            total = 5.50;
        } else if (size == 8) {
            total = 7.00;
        } else if (size == 12) {
            total = 8.50;
        }
        return total;
    }
}



