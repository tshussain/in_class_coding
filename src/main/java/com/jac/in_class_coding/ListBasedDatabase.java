package com.jac.in_class_coding;

import java.util.ArrayList;
import java.util.List;

public class ListBasedDatabase implements CustomerDatabase {
    // Use Typing (Generics) to force this list to contain only Customer object
    // Specifying the variable as a List (think of this as an abstract type)
    private List<Customer> customerList;

    public ListBasedDatabase() {
        // Creating a specific type of list - ArrayList
        customerList = new ArrayList<Customer>();
    }

    // Put the customer into the database's list
    @Override
    public boolean save(Customer customer) {
        return customerList.add(customer);
    }

    // example of a method that is not part of the CustomerDatabase interface
    public void myOtherMethod() {
        System.out.println("Another method - but not part of CustomerDatabase");
    }
}
