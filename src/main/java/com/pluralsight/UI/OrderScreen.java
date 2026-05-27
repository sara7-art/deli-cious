package com.pluralsight.UI;

import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Topping;
import com.pluralsight.model.Order;
import com.pluralsight.model.Chips;


import java.util.Scanner;

public class OrderScreen
{
    // Used to read user input
    private Scanner scanner;

    // Current customer order
    private Order order;

    /*
     * Constructor
     */
    public OrderScreen() {
        scanner = new Scanner(System.in);

        // Create empty order
        order = new Order();
    }


    public void displayOrderMenu()
    {
        boolean ordering = true;

        while(ordering)
        {
            System.out.println("\n=================================");
            System.out.println("           ORDER MENU");
            System.out.println("=================================");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            /*
             * Add sandwich
             */
            if(choice == 1)
            {
                addSandwich();
            }

            /*
             * Add drink
             */
            else if(choice == 2)
            {
                addDrink();
            }

            /*
             * Add chips
             */
            else if(choice == 3)
            {
                addChips();
            }

            /*
             * Checkout
             */
            else if(choice == 4)
            {
                /*
                 * Prevent empty orders
                 */
                if(order.getProducts().size() == 0)
                {
                    System.out.println("Order is empty.");
                }
                else
                {
                    System.out.println("\n");
                    System.out.println(order.getOrderDetails());

                    ordering = false;
                }
            }

            /*
             * Cancel order
             */
            else if(choice == 0)
            {
                System.out.println("Order canceled.");

                ordering = false;
            }

            /*
             * Invalid input
             */
            else
            {
                System.out.println("Invalid option.");
            }
        }
    }

    /*
     * Creates sandwich object
     * and allows customer to customize it
     */
    public void addSandwich()
    {
        System.out.println("\nChoose sandwich size:");
        System.out.println("4");
        System.out.println("8");
        System.out.println("12");

        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nChoose bread type:");
        System.out.println("White");
        System.out.println("Wheat");
        System.out.println("Rye");
        System.out.println("Wrap");

        String bread = scanner.nextLine();

        System.out.print("\nToasted? (yes/no): ");

        String toastedInput = scanner.nextLine();

        boolean toasted = toastedInput.equalsIgnoreCase("yes");

        /*
         * Create sandwich object
         */
        Sandwich sandwich = new Sandwich(size, bread, toasted);

        /*
         * Topping menu
         */
        boolean addingToppings = true;

        while(addingToppings)
        {
            System.out.println("\n=================================");
            System.out.println("          TOPPING MENU");
            System.out.println("=================================");
            System.out.println("1. Premium Meat");
            System.out.println("2. Premium Cheese");
            System.out.println("3. Regular Topping");
            System.out.println("4. Sauce");
            System.out.println("5. Side");
            System.out.println("0. Finish Sandwich");

            System.out.print("Choose an option: ");

            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            /*
             * Premium meat
             */
            if(toppingChoice == 1)
            {
                addMeat(sandwich);
            }

            /*
             * Premium cheese
             */
            else if(toppingChoice == 2)
            {
                addCheese(sandwich);
            }

            /*
             * Free regular toppings
             */
            else if(toppingChoice == 3)
            {
                addRegularTopping(sandwich);
            }

            /*
             * Free sauces
             */
            else if(toppingChoice == 4)
            {
                addSauce();
            }

            /*
             * Free sides
             */
            else if(toppingChoice == 5)
            {
                addSide();
            }

            /*
             * Finish sandwich
             */
            else if(toppingChoice == 0)
            {
                addingToppings = false;
            }

            /*
             * Invalid input
             */
            else
            {
                System.out.println("Invalid option.");
            }
        }

        /*
         * Add sandwich into order
         */
        order.addProduct(sandwich);

        System.out.println("Sandwich added successfully.");
    }

    /*
     * Add premium meat
     */
    public void addMeat(Sandwich sandwich)
    {
        System.out.println("\nChoose meat:");
        System.out.println("Steak");
        System.out.println("Ham");
        System.out.println("Salami");
        System.out.println("Roast Beef");
        System.out.println("Chicken");
        System.out.println("Bacon");

        String meat = scanner.nextLine();

        System.out.print("Extra meat? (yes/no): ");

        String extraInput = scanner.nextLine();

        boolean extra = extraInput.equalsIgnoreCase("yes");

        /*
         * type = meat
         * extra can affect price
         */
        Topping topping = new Topping(meat, "meat", extra);

        sandwich.addTopping(topping);

        System.out.println(meat + " added.");
    }

    /*
     * Add premium cheese
     */
    public void addCheese(Sandwich sandwich)
    {
        System.out.println("\nChoose cheese:");
        System.out.println("American");
        System.out.println("Provolone");
        System.out.println("Cheddar");
        System.out.println("Swiss");

        String cheese = scanner.nextLine();

        System.out.print("Extra cheese? (yes/no): ");

        String extraInput = scanner.nextLine();

        boolean extra = extraInput.equalsIgnoreCase("yes");

        /*
         * type = cheese
         * extra can affect price
         */
        Topping topping = new Topping(cheese, "cheese", extra);

        sandwich.addTopping(topping);

        System.out.println(cheese + " added.");
    }

    /*
     * Add free regular toppings
     */
    public void addRegularTopping(Sandwich sandwich)
    {
        System.out.println("\nChoose regular topping:");
        System.out.println("Lettuce");
        System.out.println("Peppers");
        System.out.println("Onions");
        System.out.println("Tomatoes");
        System.out.println("Jalapenos");
        System.out.println("Cucumbers");
        System.out.println("Pickles");
        System.out.println("Guacamole");
        System.out.println("Mushrooms");

        String toppingName = scanner.nextLine();

        /*
         * Regular toppings are free
         */
        Topping topping = new Topping(toppingName, "regular", false);

        sandwich.addTopping(topping);

        System.out.println(toppingName + " added.");
    }

    /*
     * Add free sauces
     */
    public void addSauce()
    {
        System.out.println("\nChoose sauce:");
        System.out.println("Mayo");
        System.out.println("Mustard");
        System.out.println("Ketchup");
        System.out.println("Ranch");
        System.out.println("Thousand Islands");
        System.out.println("Vinaigrette");

        String sauce = scanner.nextLine();

        /*
         * Add sauce into order
         */
        order.addSauce(sauce);

        System.out.println(sauce + " added.");
    }
    /*
     * Add side into order
     */
    public void addSide()
    {
        System.out.println("\nChoose side:");
        System.out.println("Au Jus");
        System.out.println("Sauce");

        String side = scanner.nextLine();

        /*
         * Add side into order
         */
        order.addSide(side);

        System.out.println(side + " added.");
    }

    /*
     * Add drink into order
     */
    public void addDrink()
    {
        System.out.println("\nChoose drink size:");
        System.out.println("Small");
        System.out.println("Medium");
        System.out.println("Large");

        String size = scanner.nextLine();

        Drink drink = new Drink(size);

        order.addProduct(drink);

        System.out.println("Drink added.");
    }


    public void addChips()
    {
        Chips chips = new Chips();

        order.addProduct(chips);

        System.out.println("Chips added.");
    }
}