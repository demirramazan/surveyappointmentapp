package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Hasta;
import com.rdemir.donemprojesi.interfaces.services.IHastaService;
import com.rdemir.donemprojesi.scope.ScopeName;
import com.rdemir.donemprojesi.util.Cinsiyet;
import com.rdemir.donemprojesi.util.KanGrubu;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import java.util.List;

@Component("hastaBean")
@Scope(ScopeName.SESSION)
public class HastaController {

    @Autowired
    private IHastaService hastaService;

    private Hasta hasta;
    private List<Hasta> hastaList;
    private Hasta selectedHasta;
    private Cinsiyet cinsiyet;
    private SelectItem[] cinsiyetList = getCinsiyetList();
    private KanGrubu kanGrubu;
    private SelectItem[] kanGrubuList = getKanGrubuList();

    public HastaController() {
        hasta = new Hasta();
    }

    @PostConstruct
    public void init() {
        hastaList = hastaService.findAll();
    }

    public void saveHasta() {
        hasta.setCinsiyet(cinsiyet);
        hastaService.save(hasta);
    }

    public void deleteHasta() {
        hastaService.delete(hasta.getId());
    }

    public SelectItem[] getCinsiyetList() {
        SelectItem[] items = new SelectItem[Cinsiyet.values().length];
        int i = 0;
        for (Cinsiyet cinsiyet : Cinsiyet.values()) {
            items[i++] = new SelectItem(cinsiyet, cinsiyet.getAdi());
        }
        return items;
    }
    public SelectItem[] getKanGrubuList() {
        SelectItem[] items = new SelectItem[KanGrubu.values().length];
        int i = 0;
        for (KanGrubu kanGrubu : KanGrubu.values()) {
            items[i++] = new SelectItem(kanGrubu, kanGrubu.getName());
        }
        return items;
    }

    public KanGrubu getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(KanGrubu kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public void setKanGrubuList(SelectItem[] kanGrubuList) {
        this.kanGrubuList = kanGrubuList;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedHasta = (Hasta) event.getObject();
        this.hasta = selectedHasta;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
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

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public void setCinsiyetList(SelectItem[] cinsiyetList) {
        this.cinsiyetList = cinsiyetList;
    }
}
