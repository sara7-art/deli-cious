package com.pluralsight.UI;

import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Topping;
import com.pluralsight.model.Order;
import com.pluralsight.model.Chips;
import com.pluralsight.service.Checkout;
import com.pluralsight.signature.BLT;
import com.pluralsight.signature.PhillyCheeseSteak;


import java.util.Scanner;

public class OrderScreen {
    // Used to read user input
    private final Scanner scanner;

    // Current customer order
    private final Order order;

    // CONSTRUCTOR

    public OrderScreen() {
        scanner = new Scanner(System.in);

        // Create empty order
        order = new Order();
    }


    public void displayOrderMenu() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=================================");
            System.out.println("           ORDER MENU");
            System.out.println("=================================");
            System.out.println("1. Add Custom Sandwich");
            System.out.println("2. Add Signature Sandwich");
            System.out.println("3. Add Drink");
            System.out.println("4. Add Chips");
            System.out.println("5. Checkout");
            System.out.println("0. Cancel Order");

            System.out.print("Choose an option: ");

            int choice = getValidMenuChoice();

            // ADD SANDWICH

            if (choice == 1) {
                addCustomSandwich();
            }

            //

            else if (choice == 2) {
                addSignatureSandwich();
            }

            // ADD DRINK

            else if (choice == 3) {
                addDrink();
            }

            // ADD CHIPS

            else if (choice == 4) {
                addChips();
            }

            // CHECKOUT

            else if (choice == 5) {
                // PREVENT EMPTY ORDER

                if (order.getProducts().isEmpty()) {
                    System.out.println("Order is empty.");
                } else {
                    // Create checkout service

                    Checkout checkout =
                            new Checkout();

                    // Send order into checkout

                    checkout.displayCheckout(order);

                    ordering = false;

                }
            }

            // CANCEL ORDER

            else if (choice == 0) {
                System.out.println("Order canceled.");

                ordering = false;
            }

            // INVALID INPUT
            else {
                System.out.println("Invalid option.");
            }
        }
    }


    // CREATES SANDWICH OBJECT AND ALLOWS CUSTOMER TO CUSTOMIZE IT

    public void addCustomSandwich() {
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


        // CREATE SANDWICH OBJECT

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // TOPPING MENU

        boolean addingToppings = true;

        while (addingToppings) {
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

            int toppingChoice = getValidMenuChoice();

            // PREMIUM MEAT

            if (toppingChoice == 1) {
                addMeat(sandwich);
            }

            // PREMIUM CHEESE

            else if (toppingChoice == 2) {
                addCheese(sandwich);
            }

            // FREE REGULAR TOPPINGS

            else if (toppingChoice == 3) {
                addRegularTopping(sandwich);
            }

            // FREE SAUCES

            else if (toppingChoice == 4) {
                addSauce();
            }

            // FREE SIDES

            else if (toppingChoice == 5) {
                addSide();
            }

            // FINISH SANDWICH

            else if (toppingChoice == 0) {
                addingToppings = false;
            }

            // INVALID INPUT

            else {
                System.out.println("Invalid option.");
            }
        }

        // ADD SANDWICH INTO ORDER

        order.addProduct(sandwich);

        System.out.println("Sandwich added successfully.");
    }

    // ADD PREMIUM MEAT

    public void addMeat(Sandwich sandwich) {
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


        // TYPE = MEAT
        // EXTRA AFFECT PRICE

        Topping topping = new Topping(meat, "meat", extra);

        sandwich.addTopping(topping);

        System.out.println(meat + " added.");
    }


    // ADD PREMIUM CHEESE

    public void addCheese(Sandwich sandwich) {
        System.out.println("\nChoose cheese:");
        System.out.println("American");
        System.out.println("Provolone");
        System.out.println("Cheddar");
        System.out.println("Swiss");

        String cheese = scanner.nextLine();

        System.out.print("Extra cheese? (yes/no): ");

        String extraInput = scanner.nextLine();

        boolean extra = extraInput.equalsIgnoreCase("yes");

        // TYPE = MEAT
        // EXTRA AFFECT PRICE

        Topping topping = new Topping(cheese, "cheese", extra);

        sandwich.addTopping(topping);

        System.out.println(cheese + " added.");
    }

    // ADD FREE REGULAR TOPPINGS

    public void addRegularTopping(Sandwich sandwich) {
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

        // REGULAR TOPPINGS ARE FREE

        Topping topping = new Topping(toppingName, "regular", false);

        sandwich.addTopping(topping);

        System.out.println(toppingName + " added.");
    }

    // ADD FREE SAUCES

    public void addSauce() {
        System.out.println("\nChoose sauce:");
        System.out.println("Mayo");
        System.out.println("Mustard");
        System.out.println("Ketchup");
        System.out.println("Ranch");
        System.out.println("Thousand Islands");
        System.out.println("Vinaigrette");

        String sauce = scanner.nextLine();

        // ADD SAUCE INTO ORDER

        order.addSauce(sauce);

        System.out.println(sauce + " added.");
    }
    // ADD FREE SIDE

    public void addSide() {
        System.out.println("\nChoose side:");
        System.out.println("Au Jus");
        System.out.println("Sauce");

        String side = scanner.nextLine();

        // ADD SIDE INTO ORDER

        order.addSide(side);

        System.out.println(side + " added.");
    }


    // Add signature sandwich

    public void addSignatureSandwich() {
        System.out.println("\nChoose Signature Sandwich:");
        System.out.println("1. BLT");
        System.out.println("2. Philly Cheese Steak");

        System.out.print("Choose option: ");

        int choice = getValidMenuChoice();

        Sandwich sandwich = null;

        // Create BLT

        if (choice == 1) {
            sandwich = new BLT();


            // Add ranch sauce automatically

            order.addSauce("Ranch");
        }


        // Create Philly Cheese Steak
        else if (choice == 2) {
            sandwich = new PhillyCheeseSteak();


            // Add mayo sauce automatically

            order.addSauce("Mayo");
        } else {
            System.out.println("Invalid option.");

            return;
        }

        // Allow customer customization
        customizeSignatureSandwich(sandwich);

        // Add sandwich into order

        order.addProduct(sandwich);

        System.out.println("Signature sandwich added.");
    }

    public void customizeSignatureSandwich(Sandwich sandwich) {
        boolean customizing = true;

        while (customizing) {
            System.out.println("\nCustomize Signature Sandwich");
            System.out.println("1. Add Meat");
            System.out.println("2. Add Cheese");
            System.out.println("3. Add Regular Topping");
            System.out.println("0. Finish");

            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addMeat(sandwich);
            } else if (choice == 2) {
                addCheese(sandwich);
            } else if (choice == 3) {
                addRegularTopping(sandwich);
            } else if (choice == 0) {
                customizing = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // ADD DRINK INTO ORDER

    public void addDrink() {
        System.out.println("\nChoose drink size:");
        System.out.println("Small");
        System.out.println("Medium");
        System.out.println("Large");

        String size = scanner.nextLine();

        Drink drink = new Drink(size);

        order.addProduct(drink);

        System.out.println("Drink added.");
    }


    public void addChips() {
        Chips chips = new Chips();

        order.addProduct(chips);

        System.out.println("Chips added.");
    }

    public int getValidMenuChoice() {
        while (true) {
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                System.out.print("Please enter a number: ");
            }
        }
    }
}