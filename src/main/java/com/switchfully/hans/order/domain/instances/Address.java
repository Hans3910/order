package com.switchfully.hans.order.domain.instances;

public class Address {
    private final String streetName;
    private final String streetNumber;
    private final int postalCode;
    private final String city;

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
