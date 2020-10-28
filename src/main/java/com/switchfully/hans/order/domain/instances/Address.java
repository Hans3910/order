package domain.instances;

public class Address {
    private String streetName;
    private String number;
    private int postalCode;
    private String city;

    public Address(String streetName, String number, int postalCode, String city) {
        this.streetName = streetName;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
