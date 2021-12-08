package com.miguel.engeneering.frozzenlist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String inventoryPlace;

    public Inventory(String name) {
        super();
        this.name = name;
    }

    public Inventory(String name, String inventoryPlace) {
        this.name = name;
        this.inventoryPlace = inventoryPlace;
    }

    public Inventory() {
        this.name = "default";
    }
}
