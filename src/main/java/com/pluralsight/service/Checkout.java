package com.pluralsight.service;


import com.pluralsight.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


    // Checkout handles review, confirmation, cancellation, and saving receipts.

    public class Checkout {
        // Scanner for user input
        private final Scanner scanner;

        // Color constants
        private static final String RESET = "\u001B[0m";

        private static final String YELLOW = "\u001B[33m";

        private static final String PURPLE = "\u001B[35m";


        // Constructor

        public Checkout() {
            scanner = new Scanner(System.in);
        }


        // Display checkout screen

        public void displayCheckout(Order order) {
            boolean checkingOut = true;

            while (checkingOut) {

                // Display full order details

                System.out.println(order.getOrderDetails());

                System.out.println(PURPLE + "ORDER DETAILS" + RESET);
                System.out.println(YELLOW + "====================================" + RESET);

                System.out.println("\n1. Confirm");
                System.out.println("0. Cancel");

                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                // CONFIRM ORDER
                if (choice == 1) {
                    confirmOrder(order);

                    checkingOut = false;
                }

                // CANCEL ORDER
                else if (choice == 0) {
                    cancelOrder();

                    checkingOut = false;
                }

                // INVALID OPTION
                else {
                    System.out.println("Invalid option.");
                }
            }
        }


        // CONFIRM ORDER

        public void confirmOrder(Order order) {
            // SAVE RECEIPT FILE
            saveReceipt(order);

            System.out.println("Order confirmed.");
        }


        // CANCEL ORDER

        public void cancelOrder() {
            System.out.println("Order canceled.");
        }


        // Save receipt into receipts folder

        public void saveReceipt(Order order) {
            try {

                // Create receipts folder object

                File folder = new File("receipts");


                // Create folder if it does not exist

                if (!folder.exists()) {
                    folder.mkdir();
                }

                // Create timestamp

                LocalDateTime now = LocalDateTime.now();

                // Format:
                // yyyyMMdd-hhmmss

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

                String timestamp = now.format(formatter);


                // Create receipt file name

                String fileName = "receipts/" + timestamp + ".txt";


                // Create FileWriter

                FileWriter writer = new FileWriter(fileName);


                // Write order details into file

                writer.write(order.getOrderDetails());


                // Close writer

                writer.close();

                System.out.println("Receipt saved successfully.");

            } catch (IOException e) {
                System.out.println("Error saving receipt.");
            }
        }
    }




