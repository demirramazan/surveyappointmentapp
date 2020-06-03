package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    public User user ;

    public UserController() {
        this.user  = new User();
        user.setSurname("ramazan");
        user.setUsername("demir");
    }

    @GetMapping("/findAll")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/find/{id}")
    public User findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }




}
