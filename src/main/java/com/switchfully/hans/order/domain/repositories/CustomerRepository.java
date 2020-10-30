package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.instances.Customer;
import org.springframework.stereotype.Repository;

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

}
