package com.project.model.customer;

import com.project.model.Id;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@MappedSuperclass
abstract class Phone extends Id {
    String phone;

    @Size(min = 10, max = 30)
    @Column(name = "phone", unique = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}