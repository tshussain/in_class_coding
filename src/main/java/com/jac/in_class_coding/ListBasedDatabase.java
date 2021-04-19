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

    /** Put the customer into the database's list
     *
     *  Uniqueness of id??
     */
    @Override
    public boolean save(Customer customer) {
        return customerList.add(customer);
    }

    /** Return the matching customer if it is in the database, otherwise null.
     *
     *  Assumes uniqueness of id
     */
    @Override
    public Customer findCustomerById(int id) {
        for (Customer customer: customerList) {
            if (customer.id == id) {
                return customer;
            }
        }
        return null;
    }

    /** Removes the customer with the given id from the database if it exists.
     *
     *  Assumes uniques of id.
     */
    @Override
    public Customer removeById(int targetIdToRemove) {
        for (int index = 0; index < customerList.size(); index++) {
            Customer currentCustomerAtIndex = customerList.get(index);
            int idOfCurrentCustomer = currentCustomerAtIndex.id;
            if (idOfCurrentCustomer == targetIdToRemove) {
                Customer result = customerList.remove(index);
                return result;
            }
        }
        return null;
    }

    // example of a method that is not part of the CustomerDatabase interface
    public void myOtherMethod() {
        System.out.println("Another method - but not part of CustomerDatabase");
    }
}
