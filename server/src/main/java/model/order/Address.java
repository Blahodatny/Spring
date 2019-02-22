package model.order;

import model.Audit;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;

@MappedSuperclass
abstract class Address extends Audit {
    String toCity;
    String toStreet;

    Address() {
    }

    Address(String toCity, String toStreet) {
        this.toCity = toCity;
        this.toStreet = toStreet;
    }

    @Basic
    @Column(name = "to_city", nullable = false, length = 20)
    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @Basic
    @Column(name = "to_street", nullable = false, length = 50)
    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }
}