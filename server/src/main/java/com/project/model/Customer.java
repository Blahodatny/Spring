package com.project.model;

import com.project.model.order.Order;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
public class Customer extends EntityId {
    @Size(min = 10, max = 30)
    @Column(name = "phone", unique = true)
    private String phone;

    @NotEmpty
    @Column(name = "first_name", length = 40)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", length = 40)
    private String lastName;

    @Basic(fetch = FetchType.LAZY)
    @NotEmpty
    @Column(name = "city", length = 20)
    private String city;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street", length = 50)
    private String street;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true
    )
    private Collection<Order> orders;

    public Customer() {
    }

    public Customer(Long id, String phone, String firstName,
                    String lastName, String city, String street) {
        super(id);
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        var customer = (Customer) o;
        return Objects.equals(phone, customer.phone) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), phone, firstName, lastName, city, street);
    }
}