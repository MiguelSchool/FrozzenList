package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import com.miguel.engeneering.frozzenlist.models.User;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingListService {

    ShoppingList saveShoppingList(ShoppingList shoppingList);
    List<ShoppingList>saveAllShoppingList(List<ShoppingList> shoppingListList);

    ShoppingList findShoppingListById(Long id);
    List<ShoppingList> findShoppingListByIds(List<Long> ids);

    boolean deleteById(Long id);
    void deleteByIds(List<Long>ids);

    List<ShoppingList> findShoppingListsByFromDate(List<ShoppingList>shoppingLists, LocalDate fromDate);
    List<ShoppingList> findShoppingListsByEntireDate(List<ShoppingList>shoppingLists, LocalDate entireDate);
    List<ShoppingList> findShoppingListsByUser(List<ShoppingList>shoppingLists, User user);

    List<ShoppingList> sortShoppingListByFromDate(List<ShoppingList>shoppingLists);
    List<ShoppingList> sortShoppingListByEntireDate(List<ShoppingList>shoppingLists);
}
