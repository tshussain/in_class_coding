package com.jac.in_class_coding;


import java.util.InputMismatchException;
import java.util.Scanner;

/** Create a set of labels that we can use throughout
    the program to convey the user's choice */
enum UserChoice {
    CREATE, GETBYID, REMOVEBYID, NONE
}

public class ConsoleView {

    /** Ask the user what they want to do next */
    public UserChoice requestAction() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("What would you like to do next?");
            System.out.println("  1. Add New Customer");
            System.out.println("  2. Get Customer by Id");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> { return UserChoice.CREATE; }
                case 2 -> { return UserChoice.GETBYID;}
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
