package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "brand")
    private Set<Product> products;

    public Brand(String name) {
        this();
        this.name = name;
    }
    public Brand() {
        this.products = new HashSet<>();;
    }
}
