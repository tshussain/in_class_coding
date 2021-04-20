package com.jac.in_class_coding;

import java.util.Optional;

public class HibernateDatabase implements CustomerDatabase {
    private CustomerRepository customerRepository = InClassCodingApplication.ctx.getBean(CustomerRepository.class);

    /** Only save a customer if it is not present already in the database */
    @Override
    public boolean save(Customer customer) {
        if (customerRepository.findById(customer.getId()) != null) {
            Customer customerResult = customerRepository.save(customer);
            if (customerResult != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /** Return null if customer doesn't exist */
    @Override
    public Customer findCustomerById(int id) {
        // Optional is a special Java feature so methods can avoid returning null.  Don't worry about this for tests, etc.  Here we kinda work around it.
        Optional<Customer> result = customerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Customer removeById(int id) {
        return null;
    }
}
