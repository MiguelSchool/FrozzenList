package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double minStockValue;
    private double maxStockValue;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productType")
    private Set<Product>products;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productType")
    private Set<Tray>trays;

    public ProductType() {
       this("Default");
       this.trays = new HashSet<>();
       this.products = new HashSet<>();
    }

    public ProductType(String type) {
        this.type = type;
    }

    public ProductType(String type, double minStockValue) {
        this.type = type;
        this.minStockValue = minStockValue;
    }

    public ProductType(String type, double minStockValue, double maxStockValue) {
        this.type = type;
        this.minStockValue = minStockValue;
        this.maxStockValue = maxStockValue;
    }

}
