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
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double evaluation;
    private LocalDate date;
    private String description;

    @ManyToMany(mappedBy = "assessments")
    private final Set<User>users;

    public Assessment() {
        this.users = new HashSet<>();
    }
}
