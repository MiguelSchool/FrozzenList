package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate goodUntil;
    private LocalDate boughtAt;
    private boolean isFreezable;
    private double quantity;

    @ManyToMany(mappedBy = "products")
    Map<Long,Tray>trays;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private ProductType productType;

    @OneToOne
    private Stock stock;

    public Product(){
        this.trays = new HashMap<>();
    }

}
