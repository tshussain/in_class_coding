package com.jac.in_class_coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class SpringMvcController {

    @Autowired
    private CustomerRepository customerRepository;

    /* Returns a message to display directly on the page.
    *    Since this is returning a specific "response", we use @ResponseBody */
    // Post show this in the URL: http://localhost:8082/add
    // Get shows this in the URL: http://localhost:8082/add?name=Homer&age=13
    @GetMapping("/add")
    @ResponseBody
    public String addCustomer(String name, int age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);
        customer.setAddress("");
        customerRepository.save(customer);
        return "Added customer to repo";
    }

    /** Returns a 'view' (i.e., the name of an html file).
     *    Since it is a view, we do NOT use @ResponseBody */
    @GetMapping("/list")
    public String getCustomers(ModelMap model) {
        // Retrieve the information from the database and associate it with the
        //   attribute "customers" in the model.  This attribute needs to correspond
        //   to the name used in the html file that will be loaded.
        model.addAttribute("customers", customerRepository.findAll());

        // This is the name of the html file to display (passing the info in the model).
        return "list_customers";
    }

    /** Returns a success/fail message to be displayed on the page.  We need to use @ResponseBody */
    @GetMapping("/updateName")
    @ResponseBody
    public String updateCustomerName(int id, String newName) {
        Optional<Customer> customerToChange = customerRepository.findById(id);

        if (customerToChange.isPresent()) {
            Customer customerObject = customerToChange.get();
            customerObject.setName(newName);
            customerRepository.save(customerObject);
            return "Customer name successfully changed";
        } else {
            return "Customer id " + id + " is not valid - not in database";
        }
    }

}
