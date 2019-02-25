package com.project.model.order;

import com.project.model.Audit;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
abstract class Address extends Audit {
    String toCity;
    String toStreet;

    @Basic
    @NotEmpty
    @Column(name = "to_city", length = 20)
    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @Basic
    @NotEmpty
    @Column(name = "to_street", length = 50)
    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }
}