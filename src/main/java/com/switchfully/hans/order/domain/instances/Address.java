package com.switchfully.hans.order.domain.instances;

public class Address {
    private String streetName;
    private String streetNumber;
    private int postalCode;
    private String city;

    public Address(String streetName, String number, int postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
