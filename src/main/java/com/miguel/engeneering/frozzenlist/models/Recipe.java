package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;
    private int cookTimeMinutes;
    private Byte[] image_source;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Assessment> assessment;

    @ManyToMany(mappedBy = "recipes")
    private final Set<User>users;

    @ManyToMany(mappedBy = "recipes")
    private final List<Ingredient>ingredients;

    public Recipe(){
        this.users = new HashSet<>();
        this.ingredients = new ArrayList<>();
    }

    public Recipe(String identifier, int minutes){
        this();
        this.identifier = identifier;
        this.cookTimeMinutes = minutes;
    }

    public Recipe(String identifier, int minutes, Byte[]image_source){
        this(identifier,minutes);
        this.image_source = image_source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id.equals(recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
