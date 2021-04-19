package com.jac.in_class_coding;

import java.util.Optional;

public class HibernateDatabase implements CustomerDatabase {
    private CustomerRepository customerRepository = InClassCodingApplication.ctx.getBean(CustomerRepository.class);

    @Override
    public boolean save(Customer customer) {
       Customer customerResult = customerRepository.save(customer);
       if (customerResult != null) {
           return true;
       } else {
           return false;
       }

    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }

    @Override
    public Customer removeById(int id) {
        return null;
    }
}
