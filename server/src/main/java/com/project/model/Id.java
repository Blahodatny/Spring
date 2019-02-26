package com.project.model;

import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@MappedSuperclass
public abstract class Id implements Serializable {
    protected Long id;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}