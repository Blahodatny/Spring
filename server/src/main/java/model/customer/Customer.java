package model.customer;

import model.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", catalog = "Boot", schema = "public")
public class Customer extends Id {
    private String phone;
    private String first_name;
    private String last_name;

    public Customer() {
    }

    public Customer(String phone, String first_name, String last_name, String street, String city) {
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}