package com.rdemir.donemprojesi.interfaces.services;

import java.util.List;

public interface IPersonelService<T> {
    List<T> getPersonelList();

    T getPersonel(Long id);

    void save(T t);

    void delete(Long id);
}
