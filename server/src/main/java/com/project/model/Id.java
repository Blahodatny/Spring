package com.project.model;

import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@MappedSuperclass
public abstract class Id implements Serializable {
    protected Long id;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}