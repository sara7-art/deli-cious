package com.pluralsight.model;

public class Drink extends Product
{
    // Encapsulation
    private final String size;

    /*
     * Constructor
     */
    public Drink(String size)
    {
        /*
         * Call parent constructor
         */
        super("Drink");

        this.size = size;
    }

    /*
     * Get drink size
     */
    public String getSize()
    {
        return size;
    }

    /*
     * Calculate drink price
     */
    @Override
    public double calculatePrice()
    {
        double price = 0;

        /*
         * Small drink
         */
        if(size.equalsIgnoreCase("small"))
        {
            price = 2.00;
        }

        /*
         * Medium drink
         */
        else if(size.equalsIgnoreCase("medium"))
        {
            price = 2.50;
        }

        /*
         * Large drink
         */
        else if(size.equalsIgnoreCase("large"))
        {
            price = 3.00;
        }

        return price;
    }

    /*
     * Create receipt text
     */
    public String getReceiptText()
    {
        String text = "";

        text += "=================================\n";
        text += "Drink\n";
        text += "Size: " + size + "\n";
        text += "Price: $" + calculatePrice() + "\n";

        return text;
    }
}
