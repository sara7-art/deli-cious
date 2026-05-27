package com.pluralsight.model;

import java.util.ArrayList;

public class Order {
    //Polymorphism:
    // One list stores all product types

    private final ArrayList<Product> products;

    //Free dipping sauces

    private final ArrayList<String> sauces;


    // Free side items

    private final ArrayList<String> sides;


    // Constructor

    public Order() {
        products = new ArrayList<Product>();
        sauces = new ArrayList<String>();
        sides = new ArrayList<String>();
    }


    // Add product into order

    public void addProduct(Product product) {
        products.add(product);
    }

    // Add sauce into order

    public void addSauce(String sauce)
    {
        sauces.add(sauce);
    }


    // Add side into order

    public void addSide(String side)
    {
        sides.add(side);
    }



    // Get all products

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<String> getSauces()
    {
        return sauces;
    }

    public ArrayList<String> getSides()
    {
        return sides;
    }


    // Calculate total order price

    public double calculateTotal() {
        double total = 0;

        /*
         * Loop through all products
         */
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).calculatePrice();
        }

        return total;
    }


    // Build full order details text

    public String getOrderDetails() {
        String text = "";

        text += "=================================\n";
        text += "         ORDER DETAILS\n";
        text += "=================================\n";

        /*
         * Loop through all products
         */
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            /*
             * Sandwich
             */
            if (product instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) product;

                text += sandwich.getReceiptText();
            }

            /*
             * Drink
             */
            else if (product instanceof Drink) {
                Drink drink = (Drink) product;

                text += drink.getReceiptText();
            }

            /*
             * Chips
             */
            else if (product instanceof Chips) {
                Chips chips = (Chips) product;

                text += chips.getReceiptText();
            }
        }
        /*
         * Display sauces
         */
        if(sauces.size() > 0)
        {
            text += "\nFree Sauces:\n";

            for(int i = 0; i < sauces.size(); i++)
            {
                text += "- " + sauces.get(i) + "\n";
            }
        }

        /*
         * Display sides
         */
        if(sides.size() > 0)
        {
            text += "\nFree Sides:\n";

            for(int i = 0; i < sides.size(); i++)
            {
                text += "- " + sides.get(i) + "\n";
            }
        }

        text += "=================================\n";
        text += "TOTAL: $" + calculateTotal() + "\n";

        return text;
    }
}

