package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.exceptions.NotACustomerException;
import com.switchfully.hans.order.domain.instances.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Repository
public class CustomerRepository {
    private static final Map<String, Customer> customers = new HashMap<>();

    public static Map<String, Customer> getCustomers() {
        return customers;
    }

    public static List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getById(String id) {
        return customers.get(id);
    }

    public void checkCustomerId(@RequestParam(required = false) String customerId) throws NotACustomerException {
        if (customerId == null || customerId.isBlank() || !getCustomers().containsKey(customerId)) {
            throw new NotACustomerException(Customer.class, "customerId", customerId);
        }
    }
}
