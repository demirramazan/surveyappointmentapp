package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.*;
import com.rdemir.donemprojesi.interfaces.services.*;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
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
    @Autowired
    private IBirimService birimService;
    @Autowired
    private IPersonelService personelService;

    private Birim birim;
    private List<Birim> birimList;
    private Personel personel;
    private List<Personel> personelList;

    private Hasta hasta;
    private Hasta selectedHasta;
    private List<Hasta> hastaList;
    private HastaBasvuru hastaBasvuru;
    private HastaBasvuruDetay hastaBasvuruDetay;
    private List<HastaBasvuru> hastaBasvuruList;

    @PostConstruct
    public void init() {
        hastaList = hastaService.findAll();
        hastaBasvuruList = hastaBasvuruService.findAll();
        birimList = birimService.getBirimList();
        personelList = personelService.getPersonelList();
    }

    public HastaBasvuruController() {
        hasta = new Hasta();
        hastaBasvuru = new HastaBasvuru();
        hastaBasvuruDetay = new HastaBasvuruDetay();
    }

    public void save() {
        hastaBasvuru.setHasta(hasta);
        hastaBasvuru = (HastaBasvuru) hastaBasvuruService.save(hastaBasvuru);

        hastaBasvuruDetay.setHastaBasvuru(hastaBasvuru);
        hastaBasvuruDetay.setBirim(birim);
        hastaBasvuruDetay.setGelisTarihi(hastaBasvuru.getBasvuruTarihi());
        hastaBasvuruDetay.setMuayeneYapildiMi(0);
        hastaBasvuruDetay.setPersonel(personel);

        hastaBasvuruDetayService.save(hastaBasvuruDetay);
    }

    public void delete() {
        if (hastaBasvuruDetay.getId() == null)
            return;
        hastaBasvuruDetayService.delete(hastaBasvuruDetay.getId());
        hastaBasvuruService.delete(hastaBasvuru.getId());
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Hasta getSelectedHasta() {
        return selectedHasta;
    }

    public void setSelectedHasta(Hasta selectedHasta) {
        this.selectedHasta = selectedHasta;
    }

    public List<Hasta> getHastaList() {
        return hastaList;
    }

    public void setHastaList(List<Hasta> hastaList) {
        this.hastaList = hastaList;
    }

    public HastaBasvuru getHastaBasvuru() {
        return hastaBasvuru;
    }

    public void setHastaBasvuru(HastaBasvuru hastaBasvuru) {
        this.hastaBasvuru = hastaBasvuru;
    }

    public List<HastaBasvuru> getHastaBasvuruList() {
        return hastaBasvuruList;
    }

    public void setHastaBasvuruList(List<HastaBasvuru> hastaBasvuruList) {
        this.hastaBasvuruList = hastaBasvuruList;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedHasta = (Hasta) event.getObject();
        this.hasta = selectedHasta;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public List<Birim> getBirimList() {
        return birimList;
    }

    public void setBirimList(List<Birim> birimList) {
        this.birimList = birimList;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public HastaBasvuruDetay getHastaBasvuruDetay() {
        return hastaBasvuruDetay;
    }

    public void setHastaBasvuruDetay(HastaBasvuruDetay hastaBasvuruDetay) {
        this.hastaBasvuruDetay = hastaBasvuruDetay;
    }
}
