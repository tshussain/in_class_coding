package com.jac.in_class_coding.repository;

import com.jac.in_class_coding.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
