package com.rdemir.donemprojesi.services.interfaces;

import java.util.List;

public interface IBirimService<T> {
    List<T> getBirimList();

    T getBirim(Long id);

    void save(T t);

    void delete(Long id);
}
