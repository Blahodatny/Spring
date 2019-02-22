package model.order.item;

import model.Id;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Positive;

@MappedSuperclass
abstract class Quantity extends Id {
    int quantity;

    @Basic
    @Positive
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}