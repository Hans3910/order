package com.switchfully.hans.order.domain.instances;

public class Customer extends Person {

    private final String email;
    private final Address address;
    private final String phoneNumber;


    public Customer(String firstName, String lastName, String email, Address address, String phoneNumber) {
        super(firstName, lastName);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
