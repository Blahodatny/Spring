package com.project.model.order.item;

import com.project.model.order.Order;
import com.project.model.product.Product;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS", catalog = "Boot", schema = "public")
public class OrderItem extends Quantity {
    private Order order;
    private Product product;

    public OrderItem(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        var orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) &&
                quantity == orderItem.quantity;
    }

    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id",
            nullable = false
    )
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id",
            nullable = false
    )
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}