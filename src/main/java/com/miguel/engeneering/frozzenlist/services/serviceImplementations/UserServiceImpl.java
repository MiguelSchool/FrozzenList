package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Assessment;
import com.miguel.engeneering.frozzenlist.models.Recipe;
import com.miguel.engeneering.frozzenlist.models.ShoppingList;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;
import com.miguel.engeneering.frozzenlist.repositories.UserRepository;
import com.miguel.engeneering.frozzenlist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User saveUser(User user) {
       return this.userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        Iterator<User> userIterator = users.iterator();
        List<User> userList = new ArrayList<>();
        while (userIterator.hasNext()) {
            userList.add(this.save(userIterator.next()));
        }
        return userList;
    }

    @Override
    public User findUserByID(Long id) {
       return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllByID(List<Long> ids) {
        List<User> filteredUser = new ArrayList<>();
        ids.forEach(id -> filteredUser.add(this.findUserByID(id)));
        return filteredUser;
    }

    @Override
    public User findUserByLastName(String name) {
        User userTemp =null;
        Iterator<User> userIterator =  this.userRepository.findAll().iterator();
        while (userIterator.hasNext()){
            if(userIterator.next().getLastName().equals(name)){
                userTemp = userIterator.next();
            }
        }
        return userTemp;
    }

    @Override
    public User findUserByFirstName(String name) {
        User userTemp = null;
        Iterator<User> userIterator = this.userRepository.findAll().iterator();
        while(userIterator.hasNext()){
            if(userIterator.next().getFirstName().equals(name)){
                userTemp = userIterator.next();
            }
        }
        return userTemp;
    }

    @Override
    public User findUserByEmail(String email) {
        User userTemp = null;
        Iterator<User> userIterator = this.userRepository.findAll().iterator();
        while (userIterator.hasNext()){
            if(userIterator.next().getEmail().equals(email)){
                userTemp = userIterator.next();
            }
        }
        return userTemp;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public List<User> sortUserByFirstName(List<User>userList) {
        return userList.stream()
                       .sorted(Comparator.comparing(User::getFirstName))
                       .toList();
    }

    @Override
    public List<User> sortUserByLastName(List<User>userList) {
        return userList.stream()
                       .sorted(Comparator.comparing(User::getLastName))
                       .toList();
    }

    @Override
    public List<User> sortUserByEmail(List<User>userList) {
        return userList.stream()
                       .sorted(Comparator.comparing(User::getEmail))
                       .toList();
    }

    @Override
    public void addInventory(User user,InventoryProvider provider, String name) {
        user.addInventory(provider,name);
    }

    @Override
    public void addShoppingList(User user, ShoppingList shoppingList) {
        user.addShoppingList(shoppingList);
    }


    @Override
    public void addRecipe(User user, Recipe recipe) {
        user.addRecipe(recipe);
    }

    @Override
    public void addAssessment(User user, Assessment assessment) {
        user.addAssessment(assessment);
    }

    private String encodePassword(String decodedPassword) {
        return this.bCryptPasswordEncoder.encode(decodedPassword);
    }

    private User save(User user) {
        user.setPassword(this.encodePassword(user.getPassword()));
        return this.userRepository.save(user);
    }
}
