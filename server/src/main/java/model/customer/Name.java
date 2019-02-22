package model.customer;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;

@MappedSuperclass
abstract class Name extends Address {
    String firstName;
    String lastName;

    Name() {
    }

    Name(String phone, String city, String street, String firstName, String lastName) {
        super(phone, city, street);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 40)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}