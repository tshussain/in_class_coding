package com.jac.in_class_coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SpringMvcController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    @ResponseBody
    public String addCustomer(String name, int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);
        customer.setAddress("");
        customerRepository.save(customer);
        return "Added customer to repo";
    }

}
