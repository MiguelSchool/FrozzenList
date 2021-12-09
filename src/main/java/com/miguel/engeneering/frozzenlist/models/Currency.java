package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String currencyUnit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency")
    private Set<Product>products;

    public Currency(String name,String currencyUnit) {
        this();
        this.name = name;
        this.currencyUnit = currencyUnit;
    }

    public Currency() {
        this.products = new HashSet<>();
    }
}
