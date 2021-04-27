package com.jac.in_class_coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SpringMvcController {

    @Autowired
    private CustomerRepository customerRepository;

    /** Sample handler method for our 'Hello World' Spring MVC example
     *    This method listens for the HTTP GET request for
     *    the url "localhost:XXXX/hello.  This request is essentially the
     *    event trigger for this handler.
     *  Since this handler returns a message to be displayed on the page,
     *     we need to use @ResponseBody.  */
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(
            @RequestParam(value = "myName", defaultValue = "World")
                    String name) {
        return String.format("Hello %s!", name);
    }

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
