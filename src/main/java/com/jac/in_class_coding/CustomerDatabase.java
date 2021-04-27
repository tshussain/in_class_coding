package com.jac.in_class_coding;

import com.jac.in_class_coding.entity.Customer;

/** Hide all the nitty-gritty details of the database *
 *
 *  Provided a way to access the data
 *   = Data Access Object (DAO)
 */
public interface CustomerDatabase {
    /* Return success or fail of a save action. */
    boolean save(Customer customer);

    Customer findCustomerById(int id);

    Customer removeById(int id);
}
