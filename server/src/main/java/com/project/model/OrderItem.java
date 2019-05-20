package com.project.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ORDER_ITEMS", catalog = "Boot", schema = "public")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
    @SequenceGenerator(name = "item",
            sequenceName = "order_item_seq",
            allocationSize = 1)
    private Long id;

    @Positive
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",
            referencedColumnName = "id",
            nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
            referencedColumnName = "id",
            nullable = false)
    private Product product;

    public OrderItem() {}

    public Order getOrder() { return order; }

    public Product getProduct() { return product; }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrderItem))
            return false;
        var orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
                Objects.equals(id, orderItem.id);
    }

    public int hashCode() { return Objects.hash(id, quantity); }
}