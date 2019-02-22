package model.order.item;

import model.Id;
import model.order.Order;
import model.product.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS", catalog = "Boot", schema = "public")
public class OrderItem extends Id {
    private int quantity;
    private Order order;
    private Product product;

    public OrderItem(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Positive
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        var orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) &&
                quantity == orderItem.quantity &&
                Objects.equals(order, orderItem.order) &&
                Objects.equals(product, orderItem.product);
    }

    public int hashCode() {
        return Objects.hash(id, quantity, order, product);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}