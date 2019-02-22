package model.product;

import model.Audit;
import model.order.item.OrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS", catalog = "Boot", schema = "public")
public class Product extends Audit {
    private String name;
    private String type;
    private Collection<OrderItem> items;

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        var product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(updatedAt, product.updatedAt) &&
                Objects.equals(name, product.name) &&
                Objects.equals(type, product.type);
    }

    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, name, type, items);
    }

    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }
}