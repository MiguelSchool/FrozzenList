package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
