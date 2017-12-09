package com.epam.course.store.domain;

import javax.persistence.Entity;

@Entity
public class Item extends BaseEntity {
    private String name;
    private double price;

    public Item() {
        this(null, 0.0);
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
