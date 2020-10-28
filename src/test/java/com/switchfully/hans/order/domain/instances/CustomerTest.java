package com.switchfully.hans.order.domain.instances;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    void GivenNewCustomer_HasAFirstname() {
        Address address = new Address("kerkstraat", "12", 3500, "Hasselt");
        Customer newCustomer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "0496433891");

        Assertions.assertNotNull(newCustomer.getFirstName());
    }

    @Test
    void GivenNewCustomer_HasALastname() {
        Address address = new Address("kerkstraat", "12", 3500, "Hasselt");
        Customer newCustomer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "0496433891");

        Assertions.assertNotNull(newCustomer.getLastName());
    }

    @Test
    void GivenNewCustomer_HasEmail() {
        Address address = new Address("kerkstraat", "12", 3500, "Hasselt");
        Customer newCustomer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "0496433891");

        Assertions.assertNotNull(newCustomer.getEmail());
    }

    @Test
    void GivenNewCustomer_HasAddress() {
        Address address = new Address("kerkstraat", "12", 3500, "Hasselt");
        Customer newCustomer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "0496433891");

        Assertions.assertNotNull(newCustomer.getAddress());
    }

    @Test
    void GivenNewCustomer_HasAPhoneNumber() {
        Address address = new Address("kerkstraat", "12", 3500, "Hasselt");
        Customer newCustomer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "0496433891");

        Assertions.assertNotNull(newCustomer.getPhoneNumber());
    }

}