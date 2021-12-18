package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Ingredient;
import com.miguel.engeneering.frozzenlist.repositories.IngredientRepository;
import com.miguel.engeneering.frozzenlist.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> saveIngredients(List<Ingredient> ingredients) {
        ingredients.forEach(this::saveIngredient);
        return ingredients;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.ingredientRepository.existsById(id)){
            this.ingredientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
            ids.forEach(this::deleteById);
    }

    @Override
    public Ingredient findIngredientById(Long id) {
        return this.ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredient> findIngredientsByIds(List<Long> ids) {
        List<Ingredient>filteredIds = new ArrayList<>();
        ids.forEach(id-> filteredIds.add(this.findIngredientById(id)));
        return filteredIds;
    }

    @Override
    public Ingredient findIngredientByName(String name) {
        Iterator<Ingredient> ingredientIterator = this.ingredientRepository.findAll().iterator();
        while (ingredientIterator.hasNext()){
            if(ingredientIterator.next().getName().equals(name)){
                return ingredientIterator.next();
            }
        }
        return null;
    }

    @Override
    public List<Ingredient> sortByName(List<Ingredient> ingredients) {
        return ingredients.stream()
                          .sorted(Comparator.comparing(Ingredient::getName))
                          .toList();
    }

    @Override
    public List<Ingredient> sortByQuantity(List<Ingredient> ingredients) {
        return ingredients.stream()
                .sorted(Comparator.comparing(Ingredient::getQuantity))
                .toList();
    }
}
