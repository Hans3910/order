package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.instances.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepository {
    private final Map<String, Admin> administrators = new HashMap<>();

    public AdminRepository() {
        fillRepository();
    }

    private void fillRepository(){
        Admin admin = new Admin("Ad", "Min", "admin@order.com");
        administrators.put(admin.getId(), admin);
    }

    public Collection<Admin> getAll() {
        return new ArrayList<>(administrators.values());
    }

    public Map<String, Admin> getAdministrators() {
        return administrators;
    }
}
