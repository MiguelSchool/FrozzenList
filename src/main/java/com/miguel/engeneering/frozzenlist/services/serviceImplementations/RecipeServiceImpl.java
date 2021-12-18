package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Recipe;
import com.miguel.engeneering.frozzenlist.repositories.RecipeRepository;
import com.miguel.engeneering.frozzenlist.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    RecipeRepository recipeRepository;
    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> saveRecipes(List<Recipe> recipes) {
        List<Recipe>recipesSavedList = new ArrayList<>();
        Iterator<Recipe>recipeIterator = recipes.iterator();
        while(recipeIterator.hasNext()){
            recipesSavedList.add(this.saveRecipe(recipeIterator.next()));
            return recipesSavedList;
        }
        return null;
    }

    @Override
    public Recipe findRecipeById(Long id) {
        return this.recipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recipe> findRecipesById(List<Long> ids) {
        List<Recipe>filteredList = new ArrayList<>();
        ids.forEach(id -> filteredList.add(this.findRecipeById(id)));
        return filteredList;
    }

    @Override
    public List<Recipe> findRecipesByName(List<Recipe>recipes, String name) {
        return recipes.stream()
                      .filter(recipe -> recipe.getIdentifier().equals(name))
                      .toList();
    }

    @Override
    public boolean deleteRecipeById(Long id) {
        if(this.recipeRepository.existsById(id)){
            this.recipeRepository.findById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteRecipesByIds(List<Long> ids) {
        ids.forEach(this::deleteRecipeById);
    }

    @Override
    public List<Recipe> sortRecipesByCookingTime(List<Recipe> recipes) {
        return recipes.stream()
                      .sorted(Comparator.comparing(Recipe::getCookTimeMinutes))
                      .toList();
    }

    @Override
    public List<Recipe> sortRecipesByName(List<Recipe> recipes) {
        return recipes.stream()
                      .sorted(Comparator.comparing(Recipe::getIdentifier))
                      .toList();
    }
}
