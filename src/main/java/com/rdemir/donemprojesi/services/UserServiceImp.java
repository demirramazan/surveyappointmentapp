package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.UserImp;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService<UserImp> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserImp getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<UserImp> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserImp save(UserImp userImp) {
        return userRepository.save(userImp);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
