package com.jac.in_class_coding;

public interface CustomerDatabase {
    boolean save(Customer customer);

    Customer findCustomerById(int id);
}
