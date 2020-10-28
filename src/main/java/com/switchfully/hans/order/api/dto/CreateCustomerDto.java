package com.switchfully.hans.order.api.dto;

public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String streetNumber;
    private int postalCode;
    private String city;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public CreateCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public CreateCustomerDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public CreateCustomerDto setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public CreateCustomerDto setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CreateCustomerDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CreateCustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
