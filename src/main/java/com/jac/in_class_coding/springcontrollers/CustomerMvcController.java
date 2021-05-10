package com.jac.in_class_coding.springcontrollers;

import com.jac.in_class_coding.entity.Customer;
import com.jac.in_class_coding.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerMvcController {

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
    @GetMapping("/chooseCustomerEditStep1")
    public String chooseCustomers(ModelMap model) {
        // Retrieve the information from the database and associate it with the
        //   attribute "customers" in the model.  This attribute needs to correspond
        //   to the name used in the html file that will be loaded.
        model.addAttribute("customers", customerRepository.findAll());

        // This is the name of the html file to display (passing the info in the model).
        return "select_customerEditStep2";
    }

    /** Returns a 'view' (i.e., the name of an html file).
     *    Since it is a view, we do NOT use @ResponseBody */
    @GetMapping("/chooseCustomerEditStep1_alternate")
    public String chooseCustomersAlternate(ModelMap model) {
        // Retrieve the information from the database and associate it with the
        //   attribute "customers" in the model.  This attribute needs to correspond
        //   to the name used in the html file that will be loaded.
        model.addAttribute("customers", customerRepository.findAll());

        // This is the name of the html file to display (passing the info in the model).
        return "select_customerEditStep2_radioButtonversion";
    }

    /** Returns a 'view' (i.e., the name of an html file).
     *    Since it is a view, we do NOT use @ResponseBody */
    @GetMapping("/editCustomerEditStep3")
    public String editCustomer(Integer parameterPassedToHandler_id, ModelMap model) {

        Optional<Customer> customerToChange = customerRepository.findById(parameterPassedToHandler_id);

        if (customerToChange.isPresent()) {
            Customer customerObject = customerToChange.get();
            // Retrieve the information from the database and associate it with the
            //   attribute "customers" in the model.  This attribute needs to correspond
            //   to the name used in the html file that will be loaded.
            model.addAttribute("customer", customerObject);

            // This is the name of the html file to display (passing the info in the model).
            return "edit_customer_infoEditStep4";
        }
        return "redirect:/index.html"; // if error, go back to home page
    }


    /** Returns a 'view' (i.e., the name of an html file).
     *    Since it is a view, we do NOT use @ResponseBody */
    @GetMapping("/editCustomerEditStep3_alternate")
    public String editCustomer(Integer parameterPassedToHandler_id, String usersChoice, ModelMap model) {
        if(parameterPassedToHandler_id == null || usersChoice.equals("Cancel")) {
            model.addAttribute("feedback_message", "Customer cancelled name change operation");
            model.addAttribute("networkImageUrl", "https://simpleandseasonal.com/wp-content/uploads/2018/02/Crockpot-Express-E6-Error-Code.png");
            model.addAttribute("localImageUrl", "images/pug.jpg");


            return "feedback.html";
            // or you could do this:
            // if customer cancelled, go back to home page
            // return "redirect:/index.html";
        }

        Optional<Customer> customerToChange = customerRepository.findById(parameterPassedToHandler_id);

        if (customerToChange.isPresent()) {
            Customer customerObject = customerToChange.get();
            // Retrieve the information from the database and associate it with the
            //   attribute "customers" in the model.  This attribute needs to correspond
            //   to the name used in the html file that will be loaded.
            model.addAttribute("customer", customerObject);

            // This is the name of the html file to display (passing the info in the model).
            return "edit_customer2";
        }
        return "redirect:/index.html"; // if error, go back to home page
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
    @GetMapping("/updateNameEditStep5")
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

    /** Returns a success/fail message to be displayed on the page.  We need to use @ResponseBody */
    @GetMapping("/updateCustomer")
    @ResponseBody
    public String updateCustomerInfo(@ModelAttribute("customer") Customer customer) {
    Optional<Customer> customerToChange = customerRepository.findById(customer.getId());

        if (customerToChange.isPresent()) {
            Customer customerObject = customerToChange.get();
            if (!customer.getName().equals("Unchanged")) {
                customerObject.setName(customer.getName());
            }

            if (customer.getAge() != -1) {
                customerObject.setAge(customer.getAge());
            }

            if (!customer.getAddress().equals("Unchanged")) {
                customerObject.setAddress(customer.getAddress());
            }
            customerRepository.save(customerObject);
            return "Customer info successfully changed";
        } else {
            return "Customer id " + customer.getId() + " is not valid - not in database";
        }
    }

    /** Create the listener */
    @GetMapping("/customerChosen")
    @ResponseBody
    public String displayChosenCustomer(int customerId) {
        Optional<Customer> customerChosen = customerRepository.findById(customerId);

        if (customerChosen.isPresent()) {
            Customer customerObject = customerChosen.get();
            return "Customer chosen is: " + customerObject.getName();
        }  else {
            return "Error choosing customer";
        }
    }

    /** Create the listener */
    @GetMapping("/search")
    public String displayMatchingCustomers(String name, Model model) {
        Iterable<Customer> customerChosen = customerRepository.findAll();

        List<Customer> matchesSoFar = new ArrayList<>();

        // Loop over all customers form the repository and
        //   keep track of all the ones who have a matching name
        for (Customer customer : customerChosen) {
            if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(customer.getName(),name)) {
                matchesSoFar.add(customer);
            }
        }

        model.addAttribute("customers", matchesSoFar);

        // This is the name of the html file to display (passing the info in the model).
        return "list_customers";
    }

    /** Create the listener */
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(int id, Model model) {
        customerRepository.deleteById(id);
        model.addAttribute("feedback_message", "Customer deleted");
        model.addAttribute("networkImageUrl", "https://simpleandseasonal.com/wp-content/uploads/2018/02/Crockpot-Express-E6-Error-Code.png");
        model.addAttribute("localImageUrl", "images/pug.jpg");


        return "feedback.html";

    }
}
