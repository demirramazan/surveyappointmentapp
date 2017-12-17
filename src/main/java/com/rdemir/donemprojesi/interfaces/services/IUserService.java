package com.rdemir.donemprojesi.interfaces.services;

import com.rdemir.donemprojesi.entities.UserImp;

import java.util.List;

public interface IUserService<T> {
    UserImp getUserById(Long id);

    List<UserImp> getAllUsers();

    UserImp save(T t);

    void delete(Long id);
}
