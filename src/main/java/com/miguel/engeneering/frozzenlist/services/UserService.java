package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Assessment;
import com.miguel.engeneering.frozzenlist.models.Recipe;
import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> saveUsers(List<User>users);

    public User findUserByID(Long id);
    public List<User> findAllByID(List<Long>ids);

    public User findUserByLastName(String name);
    public User findUserByFirstName(String name);
    public User findUserByEmail(String name);

    public String deleteById(Long id);
    public String deleteAll(List<Long>ids);

    public List<User> sortUserByFirstName(List<User>userList);
    public List<User> sortUserByLastName(List<User>userList);
    public List<User> sortUserByEmail(List<User>userList);

    public void addInventory(User user ,InventoryProvider provider, String name);
    public void addShoppingList(User user, ShoppingList shoppingList);
    public void addRecipe(User user, Recipe recipe);
    public void addAssessment(User user,Assessment assessment);
}
