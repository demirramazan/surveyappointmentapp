package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Cihaz;
import com.rdemir.donemprojesi.entities.RandevuSablon;
import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.interfaces.services.ICihazService;
import com.rdemir.donemprojesi.interfaces.services.IRandevuSablonService;
import com.rdemir.donemprojesi.interfaces.services.ISalonService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("randevuSablonBean")
@Scope(ScopeName.REQUEST)
public class RandevuSablonController {
    @Autowired
    private IRandevuSablonService randevuSablonService;

    @Autowired
    private ISalonService salonService;

    @Autowired
    private ICihazService cihazService;

    private Salon salon;
    private Cihaz cihaz;
    private RandevuSablon randevuSablon;
    private RandevuSablon selectedRandSablon;
    private List<RandevuSablon> randevuSablonList;
    private List<Salon> salonList;
    private List<Cihaz> cihazList;

    @PostConstruct
    public void init() {
        randevuSablonList = randevuSablonService.findAll();
        salonList = salonService.getSalonList();
        cihazList = cihazService.getCihazList();
    }

    public RandevuSablonController() {
        randevuSablon = new RandevuSablon();
    }

    public void saveSablon() {
        randevuSablon.setCihaz(cihaz);
        randevuSablon.setSalon(salon);
        randevuSablonService.save(randevuSablon);
    }

    public void deleteSablon() {
        randevuSablonService.delete(randevuSablon.getId());
    }

    public List<Salon> getSalonList() {
        return salonList;
    }

    public void setSalonList(List<Salon> salonList) {
        this.salonList = salonList;
    }

    public List<Cihaz> getCihazList() {
        return cihazList;
    }

    public void setCihazList(List<Cihaz> cihazList) {
        this.cihazList = cihazList;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Cihaz getCihaz() {
        return cihaz;
    }

    public void setCihaz(Cihaz cihaz) {
        this.cihaz = cihaz;
    }

    public RandevuSablon getRandevuSablon() {
        return randevuSablon;
    }

    public void setRandevuSablon(RandevuSablon randevuSablon) {
        this.randevuSablon = randevuSablon;
    }

    public RandevuSablon getSelectedRandSablon() {
        return selectedRandSablon;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedRandSablon = (RandevuSablon) event.getObject();
        this.randevuSablon = selectedRandSablon;
    }

    public void setSelectedRandSablon(RandevuSablon selectedRandSablon) {
        this.selectedRandSablon = selectedRandSablon;
    }

    public List<RandevuSablon> getRandevuSablonList() {
        return randevuSablonList;
    }

    public void setRandevuSablonList(List<RandevuSablon> randevuSablonList) {
        this.randevuSablonList = randevuSablonList;
    }
}
