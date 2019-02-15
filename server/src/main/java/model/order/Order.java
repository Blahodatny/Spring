package model.order;

import model.Audit;
import model.customer.Customer;
import model.order.item.OrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "ORDERS", catalog = "Boot", schema = "public")
public class Order extends Audit {
    private String toCity;
    private String toStreet;
    private Collection<OrderItem> items;
    private Customer customer;
}