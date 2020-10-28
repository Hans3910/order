package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.instances.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class CustomerRepository {
    private static final Map<String, Customer> customers = new HashMap<>();

    public static Map<String, Customer> getCustomers() {
        return customers;
    }

    public static Collection<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

}
