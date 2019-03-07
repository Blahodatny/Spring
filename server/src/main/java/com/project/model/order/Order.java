package com.project.model.order;

import com.project.model.EntityAuditing;
import com.project.model.Customer;
import com.project.model.order.item.OrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ORDERS", catalog = "Boot", schema = "public")
public class Order extends EntityAuditing {


    public Order() {
    }

    public Order(String toCity, String toStreet) {
        this.toCity = toCity;
        this.toStreet = toStreet;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        var order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(createdAt, order.createdAt) &&
                Objects.equals(updatedAt, order.updatedAt) &&
                Objects.equals(toCity, order.toCity) &&
                Objects.equals(toStreet, order.toStreet);
    }

    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, toCity, toStreet);
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "order",
            orphanRemoval = true
    )
    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            nullable = false
    )
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}