package com.pluralsight.model;

// This interface means: any class that implements it must provide
// a way to get price and description.
public interface Priceable {

    // Every product must calculate price

    double calculatePrice();
}

