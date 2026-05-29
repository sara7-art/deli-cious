package com.pluralsight.model;

import java.util.ArrayList;

public class Sandwich extends Product
    {
        // Encapsulation
        private String sandwichName;
        private final int size;

        private final String breadType;

        private final boolean toasted;

        private final ArrayList<Topping> toppings;


        public Sandwich(int size, String breadType, boolean toasted)
        {

            // CALL PARENT CONSTRUCTOR

            super("Sandwich");

            this.size = size;

            this.breadType = breadType;

            this.toasted = toasted;


            // Create empty topping list

            toppings = new ArrayList<Topping>();

            //
            sandwichName = "customSandwich";
        }



         // sandwich name

        public String getSandwichName()
        {
            return sandwichName;
        }
        public void setSandwichName(String sandwichName)
        {
            this.sandwichName = sandwichName;
        }
        // Add topping into sandwich

        public void addTopping(Topping topping)
        {
            toppings.add(topping);
        }

        public int getSize()
        {
            return size;
        }

        public String getBreadType()
        {
            return breadType;
        }

        public boolean isToasted()
        {
            return toasted;
        }

        public ArrayList<Topping> getToppings()
        {
            return toppings;
        }

        //

        @Override
        public double calculatePrice()
        {
            double total = 0;


            // Base sandwich price

            if(size == 4)
            {
                total = 5.50;
            }
            else if(size == 8)
            {
                total = 7.00;
            }
            else if(size == 12)
            {
                total = 8.50;
            }


            // Add topping prices

            for (Topping topping : toppings) {

                 // Each topping calculates its own price

                total += topping.getPrice(size);
            }

            return total;
        }


         // Create receipt text

        public String getReceiptText()
        {
            String text = "";

            text += "=================================\n";
            text += "\n" + sandwichName;
            text += "\n====================";
            text += size + "\" Sandwich\n";
            text += "Bread: " + breadType + "\n";
            text += "Toasted: " + toasted + "\n";


             // Premium meats

            text += "\nPremium Meats:\n";

            for (Topping topping : toppings) {
                if (topping.getType().equalsIgnoreCase("meat")) {
                    text += "- " + topping.getName() + " ..... $"
                            + topping.getPrice(size);


                     // Display extra meat

                    if (topping.isExtra()) {
                        text += " (Extra)";
                    }

                    text += "\n";
                }
            }


             // Premium cheeses

            text += "\nPremium Cheeses:\n";

            for (Topping topping : toppings) {
                if (topping.getType().equalsIgnoreCase("cheese")) {
                    text += "- " + topping.getName() + " ..... $"
                            + topping.getPrice(size);

                    /*
                     * Display extra cheese
                     */
                    if (topping.isExtra()) {
                        text += " (Extra)";
                    }

                    text += "\n";
                }
            }

            // FREE REGULAR TOPPINGS
            text += "\nRegular Toppings:\n";

            for (Topping topping : toppings) {
                if (topping.getType().equalsIgnoreCase("regular")) {
                    text += "- " + topping.getName() + " ..... $"
                            + topping.getPrice(size) + "\n";
                }
            }

            text += "\nSandwich Price: $" + calculatePrice() + "\n";

            return text;
        }
    }

