package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS", catalog = "Boot", schema = "public")
public class OrderItem extends EntityId {
    @Positive
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Long id, int quantity) {
        super(id);
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;
        var orderItem = (OrderItem) o;
        return quantity == orderItem.quantity;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity);
    }
}