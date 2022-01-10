package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Assessment;
import com.miguel.engeneering.frozzenlist.models.Recipe;
import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    String signUpUser(User user);
    void enableUser(String email);
    List<User> saveUsers(List<User>users);
    User saveUser(User user);

    Optional<User> findUserByID(Long id);
    List<User> findAllByID(List<Long>ids);

    Optional findUserByEmail(String name);

    boolean deleteById(Long id);
    void deleteAll(List<Long>ids);

    List<User> sortUserByFirstName(List<User>userList);
    List<User> sortUserByLastName(List<User>userList);
    List<User> sortUserByEmail(List<User>userList);

    void addInventory(User user ,InventoryProvider provider, String name);
    void addShoppingList(User user, ShoppingList shoppingList);
    void addRecipe(User user, Recipe recipe);
    void addAssessment(User user,Assessment assessment);
}
