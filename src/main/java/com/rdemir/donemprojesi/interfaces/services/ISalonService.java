package com.rdemir.donemprojesi.interfaces.services;

import com.rdemir.donemprojesi.entities.Salon;

import java.util.List;

public interface ISalonService {
    List<Salon> getSalonList();

    Salon getSalon(Long id);

    void save(Salon salon);

    void delete(Long id);
}
