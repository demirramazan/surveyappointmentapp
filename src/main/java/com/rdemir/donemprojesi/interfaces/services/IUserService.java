package com.rdemir.donemprojesi.interfaces.services;

import com.rdemir.donemprojesi.entities.User;

import java.util.List;

public interface IUserService<T> {
    User getUserById(Long id);

    User getUserByUsernameAndPassword(String username, String password);

    List<User> getAllUsers();

    User save(T t);

    void delete(Long id);
}
