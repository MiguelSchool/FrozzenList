package com.miguel.engeneering.frozzenlist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private final String currencyUnit;

    public Currency(String name,String currencyUnit) {
        this.name = name;
        this.currencyUnit = currencyUnit;
    }
    public Currency() {
        this.name = "Euro";
        this.currencyUnit = "EUR";
    }
}
