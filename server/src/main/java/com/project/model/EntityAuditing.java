package com.project.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class EntityAuditing extends EntityId {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    EntityAuditing() {
    }

    EntityAuditing(Long id, Date createdAt, Date updatedAt) {
        super(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityAuditing)) return false;
        if (!super.equals(o)) return false;
        var that = (EntityAuditing) o;
        return Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), createdAt, updatedAt);
    }
}