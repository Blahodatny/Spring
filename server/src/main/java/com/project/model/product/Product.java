package com.project.model.product;

import com.project.model.order.item.OrderItem;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS", catalog = "Boot", schema = "public")
public class Product extends Data {
    private Collection<OrderItem> items;

    public Product() {
    }

    public Product(String name, String type) {
        this.name = name;
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
        return Objects.hash(id, createdAt, updatedAt, name, type);
    }

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH
            },
            mappedBy = "product",
            orphanRemoval = true
    )
    public Collection<OrderItem> getItems() {
        return items;
    }

    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }
}