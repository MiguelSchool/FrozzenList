package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String inventoryPlace;

    @ManyToMany(mappedBy = "inventories")
    private Set<User> users;

    @ManyToOne
    private InventoryType type;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
    private List<Tray> trays;

    public Inventory(String name, InventoryType type) {
        this();
        this.name = name;
        this.type = type;
    }

    public Inventory(String name, String inventoryPlace, InventoryType type) {
        this();
        this.name = name;
        this.inventoryPlace = inventoryPlace;
        this.type = type;
    }

    public Inventory() {
        this.trays = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return id.equals(inventory.id) && type.equals(inventory.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }


}
