package com.jac.in_class_coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public String getCustomers(ModelMap model) {
        // Retrieve the information from the database and associate it with the
        //   attribute "customers" in the model.  This attribute needs to correspond
        //   to the name used in the html file that will be loaded.
        model.addAttribute("customers", customerRepository.findAll());

        // This is the name of the html file to display (passing the info in the model).
        return "list_customers";
    }

}
