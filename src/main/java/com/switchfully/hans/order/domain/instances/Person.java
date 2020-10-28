package com.switchfully.hans.order.domain.instances;

import java.util.UUID;

public abstract class Person {
    private final String id;
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
