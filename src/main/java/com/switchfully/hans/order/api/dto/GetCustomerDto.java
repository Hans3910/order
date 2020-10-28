package com.switchfully.hans.order.api.dto;

public class GetCustomerDto {
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String streetName;
    private String streetNumber;
    private int postalCode;
    private String city;

    public String getId() {
        return id;
    }

    public GetCustomerDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GetCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GetCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GetCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public GetCustomerDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public GetCustomerDto setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public GetCustomerDto setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public GetCustomerDto setCity(String city) {
        this.city = city;
        return this;
    }
}
