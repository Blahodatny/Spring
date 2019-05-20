package com.project.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PRODUCTS", catalog = "Boot", schema = "public")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Product extends EntityAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product")
    @SequenceGenerator(name = "product",
            sequenceName = "product_seq",
            allocationSize = 1)
    private Long id;

    @NotEmpty
    @Column(name = "name", length = 50)
    private String name;

    @NotEmpty
    @Column(name = "type", length = 50)
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<OrderItem> items;

    public Product() {}

    public Collection<OrderItem> getItems() { return items; }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        if (!super.equals(o))
            return false;
        var product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(type, product.type);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, type);
    }
}