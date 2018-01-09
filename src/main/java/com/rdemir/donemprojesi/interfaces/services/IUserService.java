package com.rdemir.donemprojesi.interfaces.services;

import com.rdemir.donemprojesi.entities.User;

import java.util.List;

public interface IUserService<T> {
    User getUserById(Long id);

    List<User> getAllUsers();

    User save(T t);

    void delete(Long id);
}
