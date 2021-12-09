package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double evaluation;
    private LocalDate date;
    private String description;

    @ManyToMany(mappedBy = "assessments")
    private final Set<User>users;

    @ManyToOne
    private Recipe recipe;

    public Assessment() {
        this.users = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assessment that = (Assessment) o;
        return id.equals(that.id) && recipe.equals(that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipe);
    }
}
