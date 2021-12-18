package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Assessment;
import com.miguel.engeneering.frozzenlist.models.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe saveRecipe(Recipe recipe);
    List<Recipe> saveRecipes(List<Recipe>recipes);

    Recipe findRecipeById(Long id);
    List<Recipe> findRecipesById(List<Long>ids);
    List<Recipe> findRecipesByName(List<Recipe>recipes, String name);
    boolean deleteRecipeById(Long id);
    void deleteRecipesByIds(List<Long>ids);
    List<Recipe> sortRecipesByCookingTime(List<Recipe>recipes);
    List<Recipe> sortRecipesByName(List<Recipe>recipes);

}
