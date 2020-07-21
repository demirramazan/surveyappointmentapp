package com.rdemir.donemprojesi.services.interfaces;

import java.util.List;

public interface IHastaBasvuruService<T> {
    List<T> findAll();

    T findOne(Long id);

    T save(T t);

    void delete(Long id);
}
