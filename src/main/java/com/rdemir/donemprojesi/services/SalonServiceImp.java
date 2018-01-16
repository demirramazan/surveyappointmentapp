package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.interfaces.services.ISalonService;
import com.rdemir.donemprojesi.repositories.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImp implements ISalonService {
    @Autowired
    private SalonRepository salonRepository;

    @Override
    public List<Salon> getSalonList() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalon(Long id) {
        return salonRepository.getOne(id);
    }

    @Override
    public void save(Salon salon) {
        salonRepository.save(salon);
    }

    @Override
    public void delete(Long id) {
         salonRepository.delete(id);
    }
}
