package com.jac.in_class_coding.springcontrollers;

import com.jac.in_class_coding.entity.Customer;
import com.jac.in_class_coding.entity.Purchase;
import com.jac.in_class_coding.repository.CustomerRepository;
import com.jac.in_class_coding.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class PurchaseMvcController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired  // Each field that is to be autowired requires its own annotation
    private PurchaseRepository purchaseRepository;

    @GetMapping("/addPurchase")
    @ResponseBody
    public String addPurchaseToCustomer(int customerId, String item, double amount) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            /* First, create a new purchase object */
            Purchase purchase = new Purchase();
            purchase.setItemDescription(item);
            purchase.setPurchaseAmount(amount);

            /* Next, add that Purchase object to the customer object */
            Customer customer = customerOptional.get();
            customer.addPurchase(purchase);  // add item to list

            /* Now, save the new information into the repositories */
            purchaseRepository.save(purchase); // "add"
            customerRepository.save(customer); // "update"

            /* Note: not great encapsulation... directly manipulating the list
            that is inside customer (fix later).  But, on the plus side, no
            possible side-effects here since this is the only part of the
            code with this exact object reference. */
            return "Successfully added purchase";
        } else {
            return "Customer id " + customerId + " is not valid - not in database";
        }
    }

}
