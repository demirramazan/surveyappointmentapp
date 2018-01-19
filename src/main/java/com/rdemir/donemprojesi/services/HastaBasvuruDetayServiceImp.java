package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.HastaBasvuruDetay;
import com.rdemir.donemprojesi.interfaces.services.IHastaBasvuruDetayService;
import com.rdemir.donemprojesi.repositories.HastaBasvuruDetayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaBasvuruDetayServiceImp implements IHastaBasvuruDetayService<HastaBasvuruDetay> {
    @Autowired
    private HastaBasvuruDetayRepository basvuruDetayRepository;

    @Override
    public List<HastaBasvuruDetay> findAll() {
        return basvuruDetayRepository.findAll();
    }

    @Override
    public HastaBasvuruDetay findOne(Long id) {
        return basvuruDetayRepository.findOne(id);
    }

    @Override
    public void save(HastaBasvuruDetay hastaBasvuruDetay) {
        hastaBasvuruDetay.setSiraNumarasi(basvuruDetayRepository.getMaxSiraNumarasi() + 1);
        basvuruDetayRepository.save(hastaBasvuruDetay);
    }

    @Override
    public void delete(Long id) {
        basvuruDetayRepository.delete(id);
    }
}
