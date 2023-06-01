package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    @Id
    private Long id;
    @NotBlank(message = "name must be not empty")
    private String name;
    /*
     Because we ignored the password get method we have to restrict
     our 'password' property to WRITE_ONLY
     this property allows the client to send the 'password',
     but not to read the 'password' from the client
     */
    @NotBlank(message = "password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "email must be not empty")
    @Email
    private String email;

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

    public String getEmail() {
        return email;
    }
}
