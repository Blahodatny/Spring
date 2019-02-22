package model.product;

import model.Audit;

import javax.persistence.MappedSuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
abstract class Data extends Audit {
    String name;
    String type;

    @Basic
    @NotEmpty
    @Column(name = "name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @NotEmpty
    @Column(name = "type", length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}