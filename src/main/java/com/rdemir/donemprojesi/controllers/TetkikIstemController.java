package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.*;
import com.rdemir.donemprojesi.interfaces.services.IHastaBasvuruDetayService;
import com.rdemir.donemprojesi.interfaces.services.IHastaService;
import com.rdemir.donemprojesi.interfaces.services.IHastaTetkikIstemService;
import com.rdemir.donemprojesi.interfaces.services.ITetkikService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
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

    @Autowired
    private IHastaBasvuruDetayService hastaBasvuruDetayService;
    @Autowired
    private IHastaService hastaService;

    private HastaTetkikIstem hastaTetkikIstem;
    private HastaBasvuru hastaBasvuru;
    private HastaBasvuruDetay hastaBasvuruDetay;
    private List<Tetkik> tetkikList;
    private List<HastaBasvuruDetay> hastaBasvuruDetayList;
    private List<Hasta> hastaList;
    private Hasta selectedHasta;
    private Hasta hasta;
    private Tetkik tetkik;
    private Personel personel;

    public TetkikIstemController() {
        hastaTetkikIstem = new HastaTetkikIstem();
        hastaBasvuru = new HastaBasvuru();
        hasta=new Hasta();
    }

    @PostConstruct
    public void init() {
        tetkikList = tetkikService.getTetkikList();
        hastaBasvuruDetayList = hastaBasvuruDetayService.findAll();
        hastaList = hastaService.findAll();
    }


    public void save() {
//        hastaTetkikIstem.set
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

    public List<HastaBasvuruDetay> getHastaBasvuruDetayList() {
        return hastaBasvuruDetayList;
    }

    public void setHastaBasvuruDetayList(List<HastaBasvuruDetay> hastaBasvuruDetayList) {
        this.hastaBasvuruDetayList = hastaBasvuruDetayList;
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