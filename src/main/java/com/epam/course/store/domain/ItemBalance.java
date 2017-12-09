package com.epam.course.store.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_BALANCE")
public class ItemBalance extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonBackReference
    private Storage storage;

    public ItemBalance() {
    }

    public ItemBalance(Item item, int quantity, Storage storage) {
        this.item = item;
        this.quantity = quantity;
        this.storage = storage;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
