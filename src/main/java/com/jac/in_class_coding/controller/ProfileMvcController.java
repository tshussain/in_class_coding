package com.jac.in_class_coding.controller;

import com.jac.in_class_coding.entity.Customer;
import com.jac.in_class_coding.entity.Profile;
import com.jac.in_class_coding.entity.Purchase;
import com.jac.in_class_coding.repository.CustomerRepository;
import com.jac.in_class_coding.repository.ProfileRepository;
import com.jac.in_class_coding.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ProfileMvcController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired  // Each field that is to be autowired requires its own annotation
    private ProfileRepository profileRepository;

    @GetMapping("/addProfile")
    @ResponseBody
    public String addProfileToCustomer(int customerId, String phoneNumber, String email) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            /* First, create a new purchase object */
            Profile profile = new Profile();
            profile.setPhoneNumber(phoneNumber);
            profile.setEmail(email);

            /* Next, add that Purchase object to the customer object */
            Customer customer = customerOptional.get();
            customer.setProfile(profile);  // add item to list

            /* Now, save the new information into the repositories */
            profileRepository.save(profile); // "add"
            customerRepository.save(customer); // "update"

            return "Successfully added profile";
        } else {
            return "Customer id " + customerId + " is not valid - not in database";
        }

    }


}
