package com.pluralsight.model;

import java.util.ArrayList;

public class Order {

    // One list stores all product types(POLYMORPHISM)

    private final ArrayList<Product> products;

    //Free dipping sauces

    private final ArrayList<String> sauces;


    // Free side items

    private final ArrayList<String> sides;


    // Constructor

    public Order() {
        products = new ArrayList<>();
        sauces = new ArrayList<>();
        sides = new ArrayList<>();
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


         // Loop through all products

        for (Product product : products) {
            total += product.calculatePrice();
        }

        return total;
    }


    // Build full order details text

    public String getOrderDetails() {
        String text = "";

        text += "=================================\n";
        text += "         ORDER DETAILS\n";
        text += "=================================\n";

       // LOOP THROUGH ALL PRODUCTS

        for (Product product : products) {
            /*
             * Sandwich
             */
            if (product instanceof Sandwich sandwich) {

                text += sandwich.getReceiptText();
            }

            //DRINK

            else if (product instanceof Drink drink) {

                text += drink.getReceiptText();
            }

            // CHIPS

            else if (product instanceof Chips chips) {

                text += chips.getReceiptText();
            }
        }

        // DISPLAY SAUCES


        if(!sauces.isEmpty())
        {
            text += "\nFree Sauces:\n";

            for (String sauce : sauces) {
                text += "- " + sauce + "\n";
            }
        }

        // DISPLAY SIDES
        if(!sides.isEmpty())
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

