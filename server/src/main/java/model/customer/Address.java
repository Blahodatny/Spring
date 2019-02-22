package model.customer;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;

@MappedSuperclass
abstract class Address extends Phone {
    String city;
    String street;

    Address() {
    }

    Address(String phone, String city, String street) {
        super(phone);
        this.city = city;
        this.street = street;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city", nullable = false, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street", length = 50)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}