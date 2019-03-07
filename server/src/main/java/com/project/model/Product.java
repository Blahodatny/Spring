package com.project.model;

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
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS", catalog = "Boot", schema = "public")
public class Product extends EntityAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "product_seq")
    private Long id;

    @NotEmpty
    @Column(name = "name", length = 50)
    private String name;

    @NotEmpty
    @Column(name = "type", length = 50)
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<OrderItem> items;

    public Product() {
    }

    public Product(Date createdAt, Date updatedAt, Long id, String name, String type) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Collection<OrderItem> getItems() {
        return items;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;
        var product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(type, product.type);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, type);
    }
}