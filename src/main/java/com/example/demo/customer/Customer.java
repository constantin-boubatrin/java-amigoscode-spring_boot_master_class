package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private final Long id;
    private final String name;
    /*
     Because we ignored the password get method we have to restrict
     our 'password' property to WRITE_ONLY
     this property allows the client to send the 'password',
     but not to read the 'password' from the client
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customerId") // change the property name to 'customerId'
    public Long getId() {
        return this.id;
    }

    @JsonProperty("customerName") // change the property name to 'customerName'
    public String getName() {
        return this.name;
    }

    @JsonIgnore // ignores the property
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
