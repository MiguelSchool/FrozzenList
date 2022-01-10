package com.miguel.engeneering.frozzenlist.controllers;

import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.services.serviceImplementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
      return   userService.findUserByID(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEMail(@PathVariable String email) {
        return this.userService.findUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{ids}")
    public ResponseEntity<List<User>> getUsersById(@PathVariable List<Long>ids) {
        return this.userService.findAllByID(ids)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sortByFirstName/{users}")
    public ResponseEntity<List<User>> sortUsersByFirstName(@PathVariable List<User>users) {
        return Optional.of(this.userService.sortUserByFirstName(users))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sortByLastName/{users}")
    public ResponseEntity<List<User>> sortUsersByLastName(@PathVariable List<User>users) {
        Optional<List<User>> optionalUser = Optional.of(this.userService.sortUserByLastName(users));
        return optionalUser.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sortByEmail/{users}")
    public ResponseEntity<List<User>> sortUsersByEmail(@PathVariable List<User>users) {
        return Optional.of(this.userService.sortUserByEmail(users))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>  deleteUser(@PathVariable Long id) {
        return Optional.of(this.userService.deleteById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{ids}")
    public boolean deleteUsers(@PathVariable List<Long>ids ) {
        this.userService.deleteAll(ids);
        return true;
    }

    @PutMapping("/{user}")
    public ResponseEntity<User> changeUser(@PathVariable User user) {
       return Optional.of(this.userService.saveUser(user))
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }
}
