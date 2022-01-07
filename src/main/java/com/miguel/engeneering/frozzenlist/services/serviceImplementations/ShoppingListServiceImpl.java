package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.repositories.ShoppingListRepository;
import com.miguel.engeneering.frozzenlist.services.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {

    ShoppingListRepository shoppingListRepository;

    @Override
    public ShoppingList saveShoppingList(ShoppingList shoppingList) {
        return this.shoppingListRepository.save(shoppingList);
    }

    @Override
    public List<ShoppingList> saveAllShoppingList(List<ShoppingList> shoppingListLists) {
        Iterator<ShoppingList>shoppingListIterator = shoppingListLists.iterator();
        List<ShoppingList>shoppingListsfiltered = new ArrayList<>();
        while(shoppingListIterator.hasNext()){
            shoppingListsfiltered.add(this.saveShoppingList(shoppingListIterator.next()));
        }
        return shoppingListsfiltered;
    }

    @Override
    public ShoppingList findShoppingListById(Long id) {
        return this.shoppingListRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShoppingList> findShoppingListByIds(List<Long> ids) {
        List<ShoppingList>filteredLists = new ArrayList<>();
        ids.forEach(id -> filteredLists.add(this.findShoppingListById(id)));
        return filteredLists;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.shoppingListRepository.existsById(id)){
            this.shoppingListRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public List<ShoppingList> findShoppingListsByFromDate(List<ShoppingList>shoppingLists,LocalDate fromDate) {
        return shoppingLists.stream()
                            .filter(shoppingList -> shoppingList.getFromDate().equals(fromDate))
                            .toList();
    };

    @Override
    public List<ShoppingList> findShoppingListsByEntireDate(List<ShoppingList>shoppingLists, LocalDate entireDate) {
        return shoppingLists.stream()
                            .filter(shoppingList -> shoppingList.getEntireDate().equals(entireDate))
                            .toList();
    }

    @Override
    public List<ShoppingList> findShoppingListsByUser(List<ShoppingList>shoppingLists, User user) {
        return shoppingLists.stream()
                            .filter(shoppingList -> shoppingList.getUsers().contains(user))
                            .toList();
    }

    @Override
    public List<ShoppingList> sortShoppingListByFromDate(List<ShoppingList> shoppingLists) {
        return shoppingLists.stream()
                .sorted(Comparator.comparing(ShoppingList::getFromDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoppingList> sortShoppingListByEntireDate(List<ShoppingList> shoppingLists) {
        return shoppingLists.stream()
                .sorted(Comparator.comparing(ShoppingList::getEntireDate))
                .collect(Collectors.toList());
    }
}
