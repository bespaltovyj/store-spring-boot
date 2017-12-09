package com.epam.course.store.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Storage extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "STORAGE_ITEM_COUNT",
            joinColumns = @JoinColumn(name = "storage_id"),
            inverseJoinColumns = @JoinColumn(name = "balance_id")
    )
    @JsonManagedReference
    private List<ItemBalance> itemsBalances;

    public Storage() {
        this(new ArrayList<>());
    }

    public Storage(List<ItemBalance> itemsBalances) {
        this.itemsBalances = itemsBalances;
    }

    public List<ItemBalance> getItemsBalances() {
        return itemsBalances;
    }

    public void setItemsBalances(List<ItemBalance> itemsBalances) {
        this.itemsBalances = itemsBalances;
    }

    public void addItemBalance(ItemBalance itemBalance) {
        itemsBalances.add(itemBalance);
    }
}


