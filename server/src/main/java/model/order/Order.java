package model.order;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS", catalog = "Boot", schema = "public")
public class Order {
    private String toCity;
    private String toStreet;
}