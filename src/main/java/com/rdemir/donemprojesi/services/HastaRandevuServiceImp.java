package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Randevu;
import com.rdemir.donemprojesi.interfaces.services.IHastaRandevuService;
import com.rdemir.donemprojesi.repositories.RandevuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaRandevuServiceImp implements IHastaRandevuService<Randevu> {

    @Autowired
    private RandevuRepository randevuRepository;

    @Override
    public List<Randevu> findAll() {
        return randevuRepository.findAll();
    }

    @Override
    public Randevu findOne(Long id) {
        return randevuRepository.findOne(id);
    }

    @Override
    public void save(Randevu randevu) {
        randevuRepository.save(randevu);
    }

    @Override
    public void delete(Long id) {
        randevuRepository.delete(id);
    }
}
