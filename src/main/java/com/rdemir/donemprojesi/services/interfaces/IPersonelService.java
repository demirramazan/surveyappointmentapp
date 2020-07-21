package com.rdemir.donemprojesi.services.interfaces;

import com.rdemir.donemprojesi.entities.Birim;

import java.util.List;

public interface IPersonelService<T> {
    List<T> getPersonelList();
    List<T> getPersonelListByBirim(Birim birim);

    T getPersonel(Long id);

    void save(T t);

    void delete(Long id);
}
