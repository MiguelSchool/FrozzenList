package com.miguel.engeneering.frozzenlist.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class InventoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<Inventory> inventories;
}
