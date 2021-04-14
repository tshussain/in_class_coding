package com.jac.in_class_coding;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    /** Ask the user what they want to do next */
    public UserChoice requestAction() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("What would you like to do next?");
            System.out.println("  1. Add New Customer");
            System.out.println("  2. Get Customer by Id");
            System.out.println("  3. Exit");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> { return UserChoice.CREATE; }
                case 2 -> { return UserChoice.GETBYID;}
                case 3 -> { return UserChoice.EXIT;}
                default -> {return UserChoice.NONE; }
            }
        } catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return UserChoice.NONE;
        }
    }

    /** Returns null if failed to enter properly */
    public Customer getCustomer() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Please enter customer name");
            String name = in.nextLine();

            System.out.println("Please enter customer age");
            int age = in.nextInt();
            int id = 1;

            Customer customer = new Customer(id, name, age, "");
            return customer;
        } catch (InputMismatchException ime) {
            System.out.println("Failed input");
            return null;
        }
    }
}
