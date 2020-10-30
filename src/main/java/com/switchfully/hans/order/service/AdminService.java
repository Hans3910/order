package com.switchfully.hans.order.service;

import com.switchfully.hans.order.domain.exceptions.NotAuthorizedException;
import com.switchfully.hans.order.domain.instances.Admin;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Collection<Admin> getAll() {
        return adminRepository.getAll();
    }

    private void checkAdminId(@RequestParam(required = false) String adminId) throws NotAuthorizedException {
        if (adminId == null || adminId.isBlank() || !adminRepository.getAdministrators().containsKey(adminId)) {
            throw new NotAuthorizedException(Admin.class, "librarianId", adminId);
        }
    }

}
