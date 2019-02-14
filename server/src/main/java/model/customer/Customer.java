package model.customer;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", catalog = "Boot", schema = "public")
public class Customer extends Address implements Serializable {
    private String first_name;
    private String last_name;

    public Customer() {
    }

    public Customer(String phone, String city, String street, String first_name, String last_name) {
        super(phone, city, street);
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 40)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 40)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        var customer = (Customer) o;
        return Objects.equals(phone, customer.phone) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(first_name, customer.first_name) &&
                Objects.equals(last_name, customer.last_name);
    }

    public int hashCode() {
        return Objects.hash(_id, phone, city, street, first_name, last_name);
    }
}