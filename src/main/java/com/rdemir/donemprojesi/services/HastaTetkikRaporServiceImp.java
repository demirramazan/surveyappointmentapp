package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.HastaTetkikRapor;
import com.rdemir.donemprojesi.interfaces.services.IHastaTetkikRaporService;
import com.rdemir.donemprojesi.repositories.TetkikRaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaTetkikRaporServiceImp implements IHastaTetkikRaporService<HastaTetkikRapor> {
    @Autowired
    private TetkikRaporRepository tetkikRaporRepository;

    @Override
    public List<HastaTetkikRapor> findAll() {
        return tetkikRaporRepository.findAll();
    }

    @Override
    public HastaTetkikRapor findOne(Long id) {
        return tetkikRaporRepository.findOne(id);
    }

    @Override
    public void save(HastaTetkikRapor hastaTetkikRapor) {
        tetkikRaporRepository.save(hastaTetkikRapor);
    }

    @Override
    public void delete(Long id) {
        tetkikRaporRepository.delete(id);
    }
}
