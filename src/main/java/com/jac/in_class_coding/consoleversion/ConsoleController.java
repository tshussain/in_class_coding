package com.jac.in_class_coding.consoleversion;

import com.jac.in_class_coding.CustomerDatabase;
import com.jac.in_class_coding.UserChoice;
import com.jac.in_class_coding.entity.Customer;

public class ConsoleController {
    private ConsoleView view;
    private CustomerDatabase customerDatabase;

    // Constructor
    public ConsoleController() {
    }

    /** Method to configure this controller */
    public void configure(ConsoleView view, CustomerDatabase customerDatabase) {
        this.view = view;
        this.customerDatabase = customerDatabase;
    }

    /** return false if exit */
    public boolean getAndDoNextAction() {
        UserChoice choice = view.requestAction();

        switch (choice) {
            case CREATE -> { doCreate(); return true; }
            case GETBYID -> { doGetById(); return true;}
            case REMOVEBYID -> { doRemoveByID(); return true;}
            case EXIT -> { return false; }
            default -> {return true;}
        }
    }

    private void doGetById() {
        int id = view.getIdToRetrieve();

        Customer customer = customerDatabase.findCustomerById(id);

        view.showCustomer(customer);
    }

    public void doCreate() {
        Customer myCustomer = view.getCustomer();

        if (myCustomer != null) {
            boolean success = customerDatabase.save(myCustomer);
            if (success) {
                view.showCustomer(myCustomer);
            }
        }
    }

    /** Ask user for id (via the view) and then remove it (via the model/database) */
    public void doRemoveByID() {
        // Get from user what customer to remove by asking for the id
        int id = view.getIdToRemove();
        try {
            Customer customerRemoved = customerDatabase.removeById(id);
            if (customerRemoved != null) {
                view.showCustomer(customerRemoved);
            } else {
                // TODO: This should be moved to a 'feedback' view.
                System.out.println("Remove failed");
            }
        } catch (Exception e) {
            // TODO: This should be moved to a 'feedback' view
            System.out.println("Can't remove a customer that does not exist");
            System.out.println();
        }

    }


}
