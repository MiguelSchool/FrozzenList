package com.miguel.engeneering.frozzenlist.repositories;

import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList,Long> {
}
