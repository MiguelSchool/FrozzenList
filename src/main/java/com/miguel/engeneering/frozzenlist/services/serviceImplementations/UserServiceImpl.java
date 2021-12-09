package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.repositories.UserRepository;
import com.miguel.engeneering.frozzenlist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
        if (user.getId() != null && !(this.userRepository.existsById(user.getId()))) {
            return this.save(user);
        }
        if (user.getId() != null && this.userRepository.existsById(user.getId())) {
            this.userRepository.delete(user);
            return this.save(user);
        }
        return null;
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
        Optional<User> user = Optional.empty();
        if (id != null && this.userRepository.existsById(id)) {
            user = this.userRepository.findById(id);
        }
        return user.orElse(null);
    }

    @Override
    public List<User> findAllByID(List<Long> ids) {
        List<User> filteredUser = new ArrayList<>();
        ids.forEach(id -> filteredUser.add(this.findUserByID(id)));
        return filteredUser;
    }

    @Override
    public User findUserByLastName(String name) {
        return null;
    }

    @Override
    public User findUserByFirstName(String name) {
        return null;
    }

    @Override
    public User findUserByEmail(String name) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }

    @Override
    public String deleteAll(List<Long> ids) {
        return null;
    }

    @Override
    public List<User> sortUserByFirstName() {
        return null;
    }

    @Override
    public List<User> sortUserByLastName() {
        return null;
    }

    @Override
    public List<User> sortUserByEmail() {
        return null;
    }

    private String encodePassword(String decodedPassword) {
        return this.bCryptPasswordEncoder.encode(decodedPassword);
    }

    private User save(User user) {
        user.setPassword(this.encodePassword(user.getPassword()));
        return this.userRepository.save(user);
    }
}
