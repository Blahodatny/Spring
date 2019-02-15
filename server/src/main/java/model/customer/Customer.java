package model.customer;

import model.order.Order;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", catalog = "Boot", schema = "public")
public class Customer extends Address {
    private String phone;
    private String first_name;
    private String last_name;
    private Collection<Order> orders;

    @Basic
    @Size(min = 10, max = 30)
    @Column(name = "phone", unique = true, nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return Objects.equals(_id, customer._id) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(first_name, customer.first_name) &&
                Objects.equals(last_name, customer.last_name);
    }

    public int hashCode() {
        return Objects.hash(_id, phone, city, street, first_name, last_name);
    }

    @OneToMany(mappedBy = "customer")
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}