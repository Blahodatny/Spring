package model.order;

import model.customer.Customer;
import model.order.item.OrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ORDERS", catalog = "Boot", schema = "public")
public class Order extends Address {
    private Collection<OrderItem> items;
    private Customer customer;

    public Order() {
    }

    public Order(String to_city, String to_street) {
        super(to_city, to_street);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        var order = (Order) o;
        return Objects.equals(_id, order._id) &&
                Objects.equals(created_at, order.created_at) &&
                Objects.equals(updated_at, order.updated_at) &&
                Objects.equals(to_city, order.to_city) &&
                Objects.equals(to_street, order.to_street);
    }

    public int hashCode() {
        return Objects.hash(_id, created_at, updated_at, to_city, to_street);
    }


}