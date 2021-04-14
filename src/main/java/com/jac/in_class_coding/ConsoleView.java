package com.jac.in_class_coding;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

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
