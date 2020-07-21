package com.rdemir.donemprojesi.services.interfaces;

import java.util.List;

public interface IHastaRandevuService<T> {
    List<T> findAll();

    T findOne(Long id);

    void save(T t);

    void delete(Long id);
}