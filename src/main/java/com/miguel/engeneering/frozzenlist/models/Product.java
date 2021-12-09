package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id)
                && brand.equals(product.brand) && currency.equals(product.currency) && stock.equals(product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, currency, stock);
    }


}
