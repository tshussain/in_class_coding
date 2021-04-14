package com.jac.in_class_coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InClassCodingApplication {

    public static void main(String[] args) {
        SpringApplication.run(InClassCodingApplication.class, args);

        CustomerDatabase customerDatabase = new ListBasedDatabase();

        Customer myCustomer = new Customer(1, "Joshua",
                12, "12 Park Ave");
        customerDatabase.save(myCustomer);

        // Day 1 example
        InClassExamples.switchExample();

        // Examples of accessing the same object as itself or as the interface it implements
        // uncomment out these 3 lines to see what works and what doesn't
//        customerDatabase.myOtherMethod(); // Method doesn't exist in the interface, so compile error.
//        ListBasedDatabase lb = (ListBasedDatabase) customerDatabase;
//        lb.myOtherMethod();

    }

}