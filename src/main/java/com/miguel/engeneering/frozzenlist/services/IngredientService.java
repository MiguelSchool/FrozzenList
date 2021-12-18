package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient ingredient);
    List<Ingredient>saveIngredients(List<Ingredient>ingredients);
    boolean deleteById(Long id);
    void deleteAll(List<Long>ids);

    Ingredient findIngredientById(Long id);
    List<Ingredient> findIngredientsByIds(List<Long>ids);
    Ingredient findIngredientByName(String name);

    List<Ingredient> sortByName(List<Ingredient>ingredients);
    List<Ingredient> sortByQuantity(List<Ingredient>ingredients);


}
