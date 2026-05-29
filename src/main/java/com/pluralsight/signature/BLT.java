package com.pluralsight.signature;

import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;

public class BLT extends Sandwich {

    // CONSTRUCTOR

    public BLT() {

        // 8 inch
        // white bread
        // toasted

        super(8, "White", true);
        setSandwichName("BLT");

        // ADD DEFAULT TOPPINGS

        addTopping(new Topping("Bacon", "meat", false));

        addTopping(new Topping("Cheddar", "cheese", false));

        addTopping(new Topping("Lettuce", "regular", false));

        addTopping(new Topping("Tomato", "regular", false));
    }
}
