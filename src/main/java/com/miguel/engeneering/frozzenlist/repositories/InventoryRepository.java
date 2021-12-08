package com.miguel.engeneering.frozzenlist.repositories;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory,Long> {
}
