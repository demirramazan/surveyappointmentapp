package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.HastaTetkikIstem;
import com.rdemir.donemprojesi.interfaces.services.IHastaTetkikIstemService;
import com.rdemir.donemprojesi.repositories.TetkikIstemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaTetkikIstemServiceImp implements IHastaTetkikIstemService<HastaTetkikIstem> {
    @Autowired
    private TetkikIstemRepository tetkikIstemRepository;

    @Override
    public List<HastaTetkikIstem> findAll() {
        return tetkikIstemRepository.findAll();
    }

    @Override
    public HastaTetkikIstem findOne(Long id) {
        return tetkikIstemRepository.findOne(id);
    }

    @Override
    public void save(HastaTetkikIstem hastaTetkikIstem) {
        tetkikIstemRepository.save(hastaTetkikIstem);
    }

    @Override
    public void delete(Long id) {
        tetkikIstemRepository.delete(id);
    }
}
