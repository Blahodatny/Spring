package model.order;

import model.Audit;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class Address extends Audit {
    String to_city;
    String to_street;

    Address() {
    }

    Address(String to_city, String to_street) {
        this.to_city = to_city;
        this.to_street = to_street;
    }

    @Basic
    @Column(name = "to_city", nullable = false, length = 20)
    public String getTo_city() {
        return to_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    @Basic
    @Column(name = "to_street", nullable = false, length = 50)
    public String getTo_street() {
        return to_street;
    }

    public void setTo_street(String to_street) {
        this.to_street = to_street;
    }
}