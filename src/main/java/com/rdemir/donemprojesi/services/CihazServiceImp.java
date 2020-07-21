package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Cihaz;
import com.rdemir.donemprojesi.services.interfaces.ICihazService;
import com.rdemir.donemprojesi.repositories.CihazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CihazServiceImp implements ICihazService {
    @Autowired
    private CihazRepository cihazRepository;

    @Override
    public List<Cihaz> getCihazList() {
        return cihazRepository.findAll();
    }

    @Override
    public Cihaz getSalon(Long id) {
        return cihazRepository.getOne(id);
    }

    @Override
    public void save(Cihaz cihaz) {
        cihazRepository.save(cihaz);
    }

    @Override
    public void delete(Long id) {
        cihazRepository.deleteById(id);
    }
}
