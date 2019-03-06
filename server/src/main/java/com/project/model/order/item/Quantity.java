package com.project.model.order.item;

import com.project.model.Id;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Positive;

@MappedSuperclass
abstract class Quantity extends Id {
    int quantity;

    @Positive
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}