package models;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class Id {
    Long _id;

    @javax.persistence.Id
    @GeneratedValue
    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }
}