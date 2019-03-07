package com.project.model;

import com.project.model.order.item.OrderItem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ORDERS", catalog = "Boot", schema = "public")
public class Order extends EntityAuditing {
    @NotEmpty
    @Column(name = "to_city", length = 20)
    private String toCity;

    @NotEmpty
    @Column(name = "to_street", length = 50)
    private String toStreet;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "order",
            orphanRemoval = true
    )
    private Collection<OrderItem> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Customer customer;

    public Order() {
    }

    public Order(Long id, Date createdAt, Date updatedAt,
                 String toCity, String toStreet) {
        super(id, createdAt, updatedAt);
        this.toCity = toCity;
        this.toStreet = toStreet;
    }

    public Collection<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        var order = (Order) o;
        return Objects.equals(toCity, order.toCity) &&
                Objects.equals(toStreet, order.toStreet);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), toCity, toStreet);
    }
}