package com.miguel.engeneering.frozzenlist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate goodUntil;
    private LocalDate boughtAt;
    private boolean isFreezable;
    private double quantity;

}
