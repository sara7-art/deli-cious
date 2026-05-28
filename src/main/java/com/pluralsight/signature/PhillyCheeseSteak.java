package com.pluralsight.signature;

import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;

public class PhillyCheeseSteak extends Sandwich {

    // CONSTRUCTOR
    public PhillyCheeseSteak(){
        // 8inch
        // White bread
        // Toasted
        super(8, "White", true);

        // Default Toppings
        addTopping(new Topping("Steak", "meat", false));

        addTopping(new Topping("American Cheese", "cheese", false));

        addTopping(new Topping("Peppers", "regular", false));
    }
}

