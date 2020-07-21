package com.rdemir.donemprojesi.services.interfaces;

import java.util.List;

public interface ITetkikService<T> {
    List<T> getTetkikList();

    T getTetkik(Long id);

    void save(T tetkik);

    void delete(Long id);
}
