package com.miguel.engeneering.frozzenlist.repositories;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.InventoryType;
import org.springframework.data.repository.CrudRepository;

public interface InventoryTypeRepository extends CrudRepository<InventoryType,Long> {
}
