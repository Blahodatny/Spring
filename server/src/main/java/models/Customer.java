package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", catalog = "Boot", schema = "public")
public class Customer extends Id {
    private String phone;
    private String first_name;
    private String last_name;
    private String street;
    private String city;

    public Customer() {
    }

    public Customer(String phone, String first_name, String last_name, String street, String city) {
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.city = city;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        var customer = (Customer) o;
        return _id.equals(customer._id) &&
                phone.equals(customer.phone) &&
                first_name.equals(customer.first_name) &&
                last_name.equals(customer.last_name) &&
                street.equals(customer.street) &&
                city.equals(customer.city);
    }

    public int hashCode() {
        return Objects.hash(_id, phone, first_name, last_name, street, city);
    }

    public String toString() {
        return "Customer{" +
                "phone='" + phone + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}