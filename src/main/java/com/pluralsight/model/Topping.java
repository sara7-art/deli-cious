package com.pluralsight.model;

public class Topping {

    // Encapsulation
    private final String name;

    private final String type;

    private final boolean extra;

    // CONSTRUCTOR

    public Topping(String name, String type, boolean extra)
    {
        this.name = name;

        this.type = type;

        this.extra = extra;
    }

    // GET TOPPING NAME
    public String getName()
    {
        return name;
    }

    // GET TOPPING TYPE
    public String getType()
    {
        return type;
    }

    /*
     * Check if topping is extra
     */
    public boolean isExtra()
    {
        return extra;
    }

    /*
     * Calculate topping price
     */
    public double getPrice(int sandwichSize)
    {
        double price = 0;


         // Premium meat prices

        if(type.equalsIgnoreCase("meat"))
        {
            if(sandwichSize == 4)
            {
                price = 1.00;

                if(extra)
                {
                    price += 0.50;
                }
            }
            else if(sandwichSize == 8)
            {
                price = 2.00;

                if(extra)
                {
                    price += 1.00;
                }
            }
            else if(sandwichSize == 12)
            {
                price = 3.00;

                if(extra)
                {
                    price += 1.50;
                }
            }
        }

        // PREMIUM CHEESE PRICES

        else if(type.equalsIgnoreCase("cheese"))
        {
            if(sandwichSize == 4)
            {
                price = 0.75;

                if(extra)
                {
                    price += 0.30;
                }
            }
            else if(sandwichSize == 8)
            {
                price = 1.50;

                if(extra)
                {
                    price += 0.60;
                }
            }
            else if(sandwichSize == 12)
            {
                price = 2.25;

                if(extra)
                {
                    price += 0.90;
                }
            }
        }


         // REGULAR TOPPINGS, SAUCES, AND SIDES ARE FREE

        else
        {
            price = 0;
        }

        return price;
    }
}

