package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.RandevuSeans;
import com.rdemir.donemprojesi.interfaces.services.IRandevuSeansService;
import com.rdemir.donemprojesi.repositories.RandevuSeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandevuSeansServiceImp implements IRandevuSeansService<RandevuSeans> {

    @Autowired
    private RandevuSeansRepository seansRepository;

    @Override
    public List<RandevuSeans> findAll() {
        return seansRepository.findAll();
    }

    @Override
    public RandevuSeans findOne(Long id) {
        return seansRepository.findOne(id);
    }

    @Override
    public void save(RandevuSeans randevuSeans) {
        seansRepository.save(randevuSeans);
    }

    @Override
    public void delete(Long id) {
        seansRepository.delete(id);
    }
}
