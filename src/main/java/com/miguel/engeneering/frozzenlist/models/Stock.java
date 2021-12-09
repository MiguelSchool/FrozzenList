package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double minStock;
    private double maxStock;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stock")
    Set<ShoppingList> shoppingLists;

    @OneToOne
    private Product product;

    public Stock(){
        this.shoppingLists = new HashSet<>();
    }
}
