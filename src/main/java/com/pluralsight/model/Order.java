package com.pluralsight.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
    Order class stores all products:
    - sandwiches
    - drinks
    - chips

    POLYMORPHISM:
    ArrayList<Product> can store different objects.
*/

public class Order {
    // Polymorphism
    private ArrayList<Product> products;

    // Constructor
    public Order() {

        products = new ArrayList<>();
    }

    // Add product to order
    public void addProduct(Product product) {

        products.add(product);
    }

    // Getter
    public ArrayList<Product> getProducts() {

        return products;
    }
}