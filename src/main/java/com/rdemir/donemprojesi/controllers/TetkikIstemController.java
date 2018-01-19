package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.*;
import com.rdemir.donemprojesi.interfaces.services.IHastaTetkikIstemService;
import com.rdemir.donemprojesi.interfaces.services.ITetkikService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("tetkikIstemBean")
@Scope(ScopeName.SESSION)
public class TetkikIstemController {
    @Autowired
    private IHastaTetkikIstemService hastaTetkikIstemService;

    @Autowired
    private ITetkikService tetkikService;

    private HastaTetkikIstem hastaTetkikIstem;
    private HastaBasvuru hastaBasvuru;
    private HastaBasvuruDetay hastaBasvuruDetay;
    private List<Tetkik> tetkikList;
    private Tetkik tetkik;
    private Personel personel;

    public TetkikIstemController() {
        hastaTetkikIstem = new HastaTetkikIstem();
        hastaBasvuru = new HastaBasvuru();
    }

    @PostConstruct
    public void init() {
        tetkikList = tetkikService.getTetkikList();
    }


    public void save() {
        hastaTetkikIstem.setTetkik(tetkik);
        hastaTetkikIstem.setIstemYapanPersonel(hastaBasvuruDetay.getPersonel());
        hastaTetkikIstemService.save(hastaTetkikIstem);
    }

    public void delete() {
        hastaTetkikIstemService.delete(hastaTetkikIstem.getId());
    }

    public HastaTetkikIstem getHastaTetkikIstem() {
        return hastaTetkikIstem;
    }

    public void setHastaTetkikIstem(HastaTetkikIstem hastaTetkikIstem) {
        this.hastaTetkikIstem = hastaTetkikIstem;
    }

    public HastaBasvuru getHastaBasvuru() {
        return hastaBasvuru;
    }

    public void setHastaBasvuru(HastaBasvuru hastaBasvuru) {
        this.hastaBasvuru = hastaBasvuru;
    }

    public HastaBasvuruDetay getHastaBasvuruDetay() {
        return hastaBasvuruDetay;
    }

    public void setHastaBasvuruDetay(HastaBasvuruDetay hastaBasvuruDetay) {
        this.hastaBasvuruDetay = hastaBasvuruDetay;
    }

    public List<Tetkik> getTetkikList() {
        return tetkikList;
    }

    public void setTetkikList(List<Tetkik> tetkikList) {
        this.tetkikList = tetkikList;
    }

    public Tetkik getTetkik() {
        return tetkik;
    }

    public void setTetkik(Tetkik tetkik) {
        this.tetkik = tetkik;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }
}