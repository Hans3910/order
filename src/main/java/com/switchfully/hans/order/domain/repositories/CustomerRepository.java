package domain.repositories;

import domain.instances.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();

    public Collection<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

}
