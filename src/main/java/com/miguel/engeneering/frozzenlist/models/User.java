package com.miguel.engeneering.frozzenlist.models;

import com.miguel.engeneering.frozzenlist.models.enums.UserRole;
import com.miguel.engeneering.frozzenlist.models.factories.InventoryServiceFactory;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private LocalDate birthday;
    private boolean locked;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToMany
    @JoinTable(
            name = "user_assessment",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    private Set<Assessment> assessments;

    @ManyToMany
    @JoinTable(
            name = "user_shoppingList",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "shoppinglist_id")
    )
    private Set<ShoppingList> shoppingLists;

    @ManyToMany
    @JoinTable(
            name = "user_recipe",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes;

    @ManyToMany
    @JoinTable(
            name = "user_inventory",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )
    private Set<Inventory> inventories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Map<Long, Tray> trays;

    public User(
            String email,
            String password)
    {
        this();
        this.email = email;
        this.password = password;
        this.enabled = false;
        this.locked = false;
    }

    public User() {
        this.assessments = new HashSet<>();
        this.shoppingLists = new HashSet<>();
        this.recipes = new ArrayList<>();
        this.inventories = new HashSet<>();
    }

    public void addInventory(InventoryProvider provider,String name) {

        Inventory inventory = InventoryServiceFactory.getInventory(provider,name);
        this.getInventories().add(inventory);
    }

    public void addShoppingList(ShoppingList list){
        this.shoppingLists.add(list);
    }

    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void addAssessment(Assessment assessment){
        this.assessments.add(assessment);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);

    }

    @Override
    public String getUsername() {
        return this.firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
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
