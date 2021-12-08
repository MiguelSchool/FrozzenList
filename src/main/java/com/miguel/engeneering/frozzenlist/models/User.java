package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
            joinColumns= @JoinColumn("id"),
            inverseJoinColumns = @JoinColumn("id")
    )
    private final Map<Long,Assessment> assessments;

    public User() {
        this.assessments = new HashMap<>();
    }
}
