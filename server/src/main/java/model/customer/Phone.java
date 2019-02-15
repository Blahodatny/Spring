package model.customer;

import model.Id;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
abstract class Phone extends Id {
    String phone;

    Phone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Size(min = 10, max = 30)
    @Column(name = "phone", unique = true, nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
