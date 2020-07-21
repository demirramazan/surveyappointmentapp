package com.rdemir.donemprojesi.services.interfaces;

import com.rdemir.donemprojesi.entities.Cihaz;

import java.util.List;

public interface ICihazService {

    List<Cihaz> getCihazList();

    Cihaz getSalon(Long id);

    void save(Cihaz cihaz);

    void delete(Long id);
}
