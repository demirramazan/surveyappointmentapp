package com.rdemir.donemprojesi.interfaces.services;

import java.util.List;

public interface IRandevuSablon<T> {
    List<T> findAll();

    T findOne(Long id);

    void save(T t);

    void delete(Long id);
}
