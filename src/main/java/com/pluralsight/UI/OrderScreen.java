package com.pluralsight.UI;


import java.util.Scanner;

public class OrderScreen {

    Scanner scanner = new Scanner(System.in);

    public void display() {

        boolean ordering = true;

        while (ordering) {

            System.out.println("\n===== ORDER MENU =====");

            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");

            // Read user input
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Process user choice
            switch (choice) {

                case 1:

                    System.out.println("Add Sandwich selected.");


                    // addSandwich();

                    break;

                case 2:

                    System.out.println("Add Drink selected.");


                    // addDrink();

                    break;

                case 3:

                    System.out.println("Add Chips selected.");


                    // addChips();

                    break;

                case 4:

                    System.out.println("Checkout selected.");

                    ordering = false;

                    break;

                case 0:

                    System.out.println("Order canceled.");
                    System.out.println("Returning to Home Screen...");

                    // Stop ONLY this loop
                    ordering = false;

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}
