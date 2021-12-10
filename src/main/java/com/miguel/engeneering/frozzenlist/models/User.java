package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(
            name = "user_assessment",
            joinColumns= @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    private Set<Assessment> assessments;

    @ManyToMany
    @JoinTable(
            name = "user_shoppingList",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "shoppinglist_id")
    )
    private Set<ShoppingList> shoppingLists;

    @ManyToMany
    @JoinTable(
            name = "user_recipe",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="recipe_id")
    )
    private List<Recipe> recipes;

    @ManyToMany
    @JoinTable(
            name="user_inventory",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="inventory_id")
    )
    private Set<Inventory> inventories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Map<Long,Tray>trays;

    public User() {
        this.assessments = new HashSet<>();
        this.shoppingLists = new HashSet<>();
        this.recipes = new ArrayList<>();
        this.inventories = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", assessments=" + assessments +
                ", shoppingLists=" + shoppingLists +
                ", recipes=" + recipes +
                ", inventories=" + inventories +
                ", trays=" + trays +
                '}';
    }


}
