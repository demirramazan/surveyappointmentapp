package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.config.SessionInitializer;
import com.rdemir.donemprojesi.entities.*;
import com.rdemir.donemprojesi.interfaces.services.IHastaService;
import com.rdemir.donemprojesi.interfaces.services.IHastaTetkikRaporService;
import com.rdemir.donemprojesi.interfaces.services.ITetkikService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Component("tetkikRaporBean")
@Scope(ScopeName.SESSION)
public class TetkikRaporController {

    @Autowired
    private IHastaTetkikRaporService hastaTetkikRaporService;

    @Autowired
    private ITetkikService tetkikService;
    @Autowired
    private IHastaService hastaService;

    private HastaTetkikIstem hastaTetkikIstem;
    private HastaTetkikRapor hastaTetkikRapor;
    private HastaBasvuru hastaBasvuru;
    private HastaBasvuruDetay hastaBasvuruDetay;
    private List<Tetkik> tetkikList;
    private Tetkik tetkik;
    private Personel personel;
    private List<Hasta> hastaList;
    private Hasta selectedHasta;
    private Hasta hasta;

    public TetkikRaporController() {
        hastaTetkikIstem = new HastaTetkikIstem();
        hastaBasvuru = new HastaBasvuru();
        hastaTetkikRapor = new HastaTetkikRapor();
        hasta = new Hasta();
    }

    @Inject
    private SessionInitializer sessionInitializer;

    @PostConstruct
    public void init() {
        tetkikList = tetkikService.getTetkikList();
        hastaList = hastaService.findAll();
    }


    public void save() {
        hastaTetkikRapor.setHastaTetkikIstem(hastaTetkikIstem);
        hastaTetkikRapor.setOnaylayanKullanici(sessionInitializer.getLoggedUser());
        hastaTetkikRapor.setOnayTarihi(new Date());
        hastaTetkikRapor.setRaporOnayliMi(1);
        hastaTetkikRapor.setOnayYapanUzman(hastaBasvuruDetay.getPersonel());
        hastaTetkikRaporService.save(hastaTetkikRapor);
    }

    public void delete() {
        hastaTetkikRaporService.delete(hastaTetkikIstem.getId());
    }

    public HastaTetkikRapor getHastaTetkikRapor() {
        return hastaTetkikRapor;
    }

    public void setHastaTetkikRapor(HastaTetkikRapor hastaTetkikRapor) {
        this.hastaTetkikRapor = hastaTetkikRapor;
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

    public List<Hasta> getHastaList() {
        return hastaList;
    }

    public void setHastaList(List<Hasta> hastaList) {
        this.hastaList = hastaList;
    }

    public Hasta getSelectedHasta() {
        return selectedHasta;
    }

    public void setSelectedHasta(Hasta selectedHasta) {
        this.selectedHasta = selectedHasta;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }
    public void onDcRowSelect(SelectEvent event) {
        selectedHasta = (Hasta) event.getObject();
        this.hasta = selectedHasta;
    }
}
