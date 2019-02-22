package model.customer;

import model.order.Order;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(
        name = "CUSTOMERS",
        catalog = "Boot",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(
                name = "phone_uindex",
                columnNames = "phone"
        )
)
public class Customer extends Name {
    private Collection<Order> orders;

    public Customer(String phone, String city, String street,
                    String firstName, String lastName) {
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        var customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName);
    }

    public int hashCode() {
        return Objects.hash(id, phone, city, street, firstName, lastName);
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true
    )
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}