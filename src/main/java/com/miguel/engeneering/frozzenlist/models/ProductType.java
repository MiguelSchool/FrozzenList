package com.miguel.engeneering.frozzenlist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double minStockValue;
    private double maxStockValue;

    public ProductType() {
       new ProductType("Default");
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
