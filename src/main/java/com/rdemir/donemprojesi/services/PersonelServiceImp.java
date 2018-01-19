package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Birim;
import com.rdemir.donemprojesi.entities.Personel;
import com.rdemir.donemprojesi.interfaces.services.IPersonelService;
import com.rdemir.donemprojesi.repositories.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelServiceImp implements IPersonelService<Personel> {
    @Autowired
    private PersonelRepository personelRepository;

    @Override
    public List<Personel> getPersonelList() {
        return personelRepository.findAll();
    }

    @Override
    public List<Personel> getPersonelListByBirim(Birim birim) {
//        return personelRepository.findAllByBirim_Id(birim.getId());
        return null;
    }

    @Override
    public Personel getPersonel(Long id) {
        return personelRepository.getOne(id);
    }

    @Override
    public void save(Personel personel) {
        personelRepository.save(personel);
    }

    @Override
    public void delete(Long id) {
        personelRepository.delete(id);
    }
}
