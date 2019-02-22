package model.order;

import model.customer.Customer;
import model.order.item.OrderItem;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    public Order(String toCity, String toStreet) {
        super(toCity, toStreet);
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

    @OneToMany(mappedBy = "order")
    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}