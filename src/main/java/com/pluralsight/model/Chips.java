package com.pluralsight.model;

public class Chips extends Product {


    // Constructor

    public Chips() {

        super("Chips");
    }


    // Chips always cost $1.50

    @Override
    public double calculatePrice() {
        return 1.50;
    }


    // Create receipt text

    public String getReceiptText() {
        String text = "";

        text += "=================================\n";
        text += "Chips\n";
        text += "Price: $" + calculatePrice() + "\n";

        return text;
    }
}