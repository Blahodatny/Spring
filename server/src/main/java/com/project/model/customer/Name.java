package com.project.model.customer;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
abstract class Name extends Address {
    String firstName;
    String lastName;

    @Basic
    @NotEmpty
    @Column(name = "first_name", length = 40)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @NotEmpty
    @Column(name = "last_name", length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}