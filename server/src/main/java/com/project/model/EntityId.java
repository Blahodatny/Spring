package com.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
abstract class EntityId implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "seq")
    private Long id;

    EntityId() {
    }

    EntityId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId)) return false;
        var entityId = (EntityId) o;
        return Objects.equals(id, entityId.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}