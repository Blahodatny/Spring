package model.customer;

import model.Id;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Address extends Id {
    private String street;
    private String city;

    @Basic
    @Column(name = "street", length = 50)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}