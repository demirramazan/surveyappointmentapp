package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.HastaBasvuru;
import com.rdemir.donemprojesi.interfaces.services.IHastaBasvuruService;
import com.rdemir.donemprojesi.repositories.HastaBasvuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaBasvuruServiceImp implements IHastaBasvuruService<HastaBasvuru> {
    @Autowired
    private HastaBasvuruRepository basvuruRepository;

    @Override
    public List<HastaBasvuru> findAll() {
        return basvuruRepository.findAll();
    }

    @Override
    public HastaBasvuru findOne(Long id) {
        return basvuruRepository.findOne(id);
    }

    @Override
    public void save(HastaBasvuru hastaBasvuru) {
        basvuruRepository.save(hastaBasvuru);
    }

    @Override
    public void delete(Long id) {
        basvuruRepository.delete(id);
    }
}
