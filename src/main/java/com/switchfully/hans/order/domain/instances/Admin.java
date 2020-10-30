package com.switchfully.hans.order.domain.instances;

public class Admin extends Person{
    private final String email;

    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
    }
}
