package com.pluralsight.UI;

import com.pluralsight.model.Order;
import java.util.Scanner;

public class HomeScreen {

    // Encapsulation
    private final Scanner scanner;

    // constant colors
    private static final String RESET = "\u001B[0m";

    private static final String YELLOW = "\u001B[33m";

    private static final String PURPLE = "\u001B[35m";

    // Constructor
    public HomeScreen() {

        scanner = new Scanner(System.in);
    }


    //Display Home Screen

    public void display() {

        boolean running = true;

        while (running) {

            System.out.println(YELLOW +
                    "==================================================" +
                    RESET);

            System.out.println(PURPLE +
                    "      🍔 TOAST & TASTE DELI SHOP 🍔" +
                    RESET);

            System.out.println(YELLOW +
                    "==================================================" +
                    RESET);

            System.out.println( PURPLE + """
                    
                      ____
                     / ___|   Welcome to Toast & Taste!
                    | |
                    | |___   Fresh Sandwiches & Drinks
                     \\____|
                    
                    """ + RESET);

            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("\nChoose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    // Create NEW order object

                    Order order = new Order();


                    // Open Order Screen

                    OrderScreen orderScreen =
                            new OrderScreen();

                    orderScreen.displayOrderMenu();

                    break;

                case 0:

                    System.out.println("\nThank you for visiting Toast & Taste!");
                    System.out.println("Goodbye!");

                    running = false;

                    break;

                default:

                    System.out.println("\nInvalid option. Try again.");
            }
        }
    }
}