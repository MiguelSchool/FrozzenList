package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fromDate;
    private LocalDate entireDate;
    private double budget;

    @ManyToMany(mappedBy = "shoppingLists")
    private final Set<User> users;

    @ManyToOne
    private Stock stock;

    public ShoppingList() {
        this.fromDate = LocalDate.now();
        this.users = new HashSet<>();
    }
    public ShoppingList(int validityPeriod) {
        this();
        this.entireDate = this.fromDate.plusDays(validityPeriod);
    }
    public ShoppingList(double budget){
        this();
        this.budget = budget;
    }
    public ShoppingList(int validityPeriod, double budget) {
        this(validityPeriod);
        this.budget = budget;
    }
}
