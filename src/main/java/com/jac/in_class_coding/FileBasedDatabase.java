package com.jac.in_class_coding;

//import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class FileBasedDatabase implements CustomerDatabase {
    // Use Typing (Generics) to force this list to contain only Customer object
    // Specifying the variable as a List (think of this as an abstract type)
    //private List<Customer> customerList;
    private File file;

    public FileBasedDatabase() {
        // Creating a specific type of list - ArrayList
        //customerList = new ArrayList<Customer>();
        // create a file and open it
        this.file = new File("customerdatabase.txt");
    }

    // Put the customer into the database's list
    @Override
    public boolean save(Customer customer) {
        // append customer to opened file
        return customerList.add(customer);
    }

    /** Return the matching customer if it is in the database, otherwise null. */
    @Override
    public Customer findCustomerById(int id) {
        // read file
        // dfroe ach line in file do
        // see if match, and return line
        for (Customer customer: customerList) {
            if (customer.id == id) {
                return customer;
            }
        }
        return null;
    }

    // example of a method that is not part of the CustomerDatabase interface
    public void myOtherMethod() {
        System.out.println("Another method - but not part of CustomerDatabase");
    }
}
