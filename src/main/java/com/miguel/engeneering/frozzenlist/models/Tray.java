package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@Getter
@Setter
@Entity
public class Tray {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="tray_product",
            joinColumns = @JoinColumn(name="tray_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    Map<Long, Product>products;

    @ManyToOne
    private Inventory inventory;

    @ManyToOne
    private User owner;

    @ManyToOne
    private ProductType productType;

    public Tray() {
        this.products = new TreeMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tray tray = (Tray) o;
        return id.equals(tray.id) && inventory.equals(tray.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory);
    }


}
