package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Birim;
import com.rdemir.donemprojesi.interfaces.services.IBirimService;
import com.rdemir.donemprojesi.repositories.BirimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirimServiceImp implements IBirimService<Birim> {

    @Autowired
    private BirimRepository birimRepository;

    @Override
    public List<Birim> getBirimList() {
        return birimRepository.findAll();
    }

    @Override
    public Birim getBirim(Long id) {
        return birimRepository.getOne(id);
    }

    @Override
    public void save(Birim birim) {
        birimRepository.save(birim);
    }

    @Override
    public void delete(Long id) {
        birimRepository.delete(id);
    }
}
