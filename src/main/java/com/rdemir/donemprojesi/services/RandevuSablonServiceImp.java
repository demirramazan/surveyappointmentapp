package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.RandevuSablon;
import com.rdemir.donemprojesi.interfaces.services.IRandevuSablonService;
import com.rdemir.donemprojesi.repositories.RandevuSablonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandevuSablonServiceImp implements IRandevuSablonService<RandevuSablon> {

    @Autowired
    private RandevuSablonRepository sablonRepository;

    @Override
    public List<RandevuSablon> findAll() {
        return sablonRepository.findAll();
    }

    @Override
    public RandevuSablon findOne(Long id) {
        return sablonRepository.findOne(id);
    }

    @Override
    public void save(RandevuSablon randevuSablon) {
        sablonRepository.save(randevuSablon);
    }

    @Override
    public void delete(Long id) {
        sablonRepository.delete(id);
    }
}
