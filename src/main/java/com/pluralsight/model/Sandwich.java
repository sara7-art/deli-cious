package com.pluralsight.model;

import java.util.ArrayList;

public class Sandwich extends Product
    {
        // Encapsulation
        private final int size;

        private final String breadType;

        private final boolean toasted;

        private final ArrayList<Topping> toppings;


        public Sandwich(int size, String breadType, boolean toasted)
        {
            /*
             * Call parent constructor
             */
            super("Sandwich");

            this.size = size;

            this.breadType = breadType;

            this.toasted = toasted;

            /*
             * Create empty topping list
             */
            toppings = new ArrayList<Topping>();
        }

        /*
         * Add topping into sandwich
         */
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

        @Override
        public double calculatePrice()
        {
            double total = 0;

            /*
             * Base sandwich price
             */
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

            /*
             * Add topping prices
             */
            for(int i = 0; i < toppings.size(); i++)
            {
                /*
                 * Each topping calculates its own price
                 */
                total += toppings.get(i).getPrice(size);
            }

            return total;
        }

        /*
         * Create receipt text
         */
        public String getReceiptText()
        {
            String text = "";

            text += "=================================\n";
            text += size + "\" Sandwich\n";
            text += "Bread: " + breadType + "\n";
            text += "Toasted: " + toasted + "\n";

            /*
             * Premium meats
             */
            text += "\nPremium Meats:\n";

            for(int i = 0; i < toppings.size(); i++)
            {
                Topping topping = toppings.get(i);

                if(topping.getType().equalsIgnoreCase("meat"))
                {
                    text += "- " + topping.getName();

                    /*
                     * Display extra meat
                     */
                    if(topping.isExtra())
                    {
                        text += " (Extra)";
                    }

                    text += "\n";
                }
            }

            /*
             * Premium cheeses
             */
            text += "\nPremium Cheeses:\n";

            for(int i = 0; i < toppings.size(); i++)
            {
                Topping topping = toppings.get(i);

                if(topping.getType().equalsIgnoreCase("cheese"))
                {
                    text += "- " + topping.getName();

                    /*
                     * Display extra cheese
                     */
                    if(topping.isExtra())
                    {
                        text += " (Extra)";
                    }

                    text += "\n";
                }
            }

            /*
             * Free regular toppings
             */
            text += "\nRegular Toppings:\n";

            for(int i = 0; i < toppings.size(); i++)
            {
                Topping topping = toppings.get(i);

                if(topping.getType().equalsIgnoreCase("regular"))
                {
                    text += "- " + topping.getName() + "\n";
                }
            }

            text += "\nSandwich Price: $" + calculatePrice() + "\n";

            return text;
        }
    }

