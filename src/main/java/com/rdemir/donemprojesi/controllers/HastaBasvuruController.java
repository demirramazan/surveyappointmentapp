package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Hasta;
import com.rdemir.donemprojesi.entities.HastaBasvuru;
import com.rdemir.donemprojesi.interfaces.services.IHastaBasvuruDetayService;
import com.rdemir.donemprojesi.interfaces.services.IHastaBasvuruService;
import com.rdemir.donemprojesi.interfaces.services.IHastaService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("hastaBasvuruBean")
@Scope(ScopeName.SESSION)
public class HastaBasvuruController {

    @Autowired
    private IHastaBasvuruService hastaBasvuruService;

    @Autowired
    private IHastaService hastaService;
    @Autowired
    private IHastaBasvuruDetayService hastaBasvuruDetayService;

    private Hasta hasta;
    private Hasta selectedHasta;
    private List<Hasta> hastaList;
    private HastaBasvuru hastaBasvuru;
    private List<HastaBasvuru> hastaBasvuruList;

    @PostConstruct
    public void init() {
        hastaList = hastaService.findAll();
    }

    public HastaBasvuruController() {
        hastaBasvuru = new HastaBasvuru();
    }
}
