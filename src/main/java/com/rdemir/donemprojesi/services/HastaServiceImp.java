package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Hasta;
import com.rdemir.donemprojesi.interfaces.services.IHastaService;
import com.rdemir.donemprojesi.repositories.HastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaServiceImp implements IHastaService<Hasta> {

    @Autowired
    private HastaRepository hastaRepository;

    @Override
    public List<Hasta> findAll() {
        return hastaRepository.findAll();
    }

    @Override
    public Hasta findOne(Long id) {
        return hastaRepository.findOne(id);
    }

    @Override
    public void save(Hasta hasta) {
        hastaRepository.save(hasta);
    }

    @Override
    public void delete(Long id) {
        hastaRepository.delete(id);
    }
}

