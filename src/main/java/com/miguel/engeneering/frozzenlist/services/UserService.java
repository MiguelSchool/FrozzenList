package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.User;

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

    public List<User> sortUserByFirstName();
    public List<User> sortUserByLastName();
    public List<User> sortUserByEmail();

}
