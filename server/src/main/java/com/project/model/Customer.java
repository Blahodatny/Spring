package com.project.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMERS",
        catalog = "Boot",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(name = "phone_uindex",
                columnNames = "phone"))
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer")
    @SequenceGenerator(name = "customer",
            sequenceName = "customer_seq",
            allocationSize = 1)
    private Long id;

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

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private Collection<Order> orders;

    public Customer() {}

    public Long getId() { return id; }

    public String getCity() { return city; }

    public String getStreet() { return street; }

    public Collection<Order> getOrders() { return orders; }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        var customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(street, customer.street);
    }

    public int hashCode() {
        return Objects.hash(id, phone, firstName, lastName, city, street);
    }

    public void updateWith(Customer customer) {
        phone = customer.phone;
        firstName = customer.firstName;
        lastName = customer.lastName;
        city = customer.city;
        street = customer.street;
    }
}