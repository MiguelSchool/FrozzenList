package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Byte[] imagePath;
    private int quantity;
    private String quantityUnit;

    @ManyToMany
    @JoinTable(
            name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id")
    )
    private List<Recipe>recipes;

    public Ingredient() {
        this.recipes = new ArrayList<>();
    }

    public Ingredient(String name, String quantityUnit) {
        this();
        this.name = name;
        this.quantityUnit = quantityUnit;
    }
}
