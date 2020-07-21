package com.rdemir.donemprojesi.services.interfaces;

import com.rdemir.donemprojesi.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IUserService<T> {
    User getUserById(Long id);

    User getUserByUsernameAndPassword(String username, String password);

    List<User> getAllUsers();

    User save(T t);

    void delete(Long id);

    User login(String username, String password, HttpSession httpSession);
}
