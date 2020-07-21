package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Tetkik;
import com.rdemir.donemprojesi.services.interfaces.ITetkikService;
import com.rdemir.donemprojesi.repositories.TetkikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TetkikServiceImp implements ITetkikService<Tetkik> {
    @Autowired
    private TetkikRepository tetkikRepository;

    @Override
    public List<Tetkik> getTetkikList() {
        return tetkikRepository.findAllByAktifMi(true);
    }

    @Override
    public Tetkik getTetkik(Long id) {
        return tetkikRepository.getOne(id);
    }

    @Override
    public void save(Tetkik tetkik) {
        tetkikRepository.save(tetkik);
    }

    @Override
    public void delete(Long id) {
        tetkikRepository.deleteById(id);
    }
}
