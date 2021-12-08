package com.miguel.engeneering.frozzenlist.repositories;

import com.miguel.engeneering.frozzenlist.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
