package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.RandevuSablon;
import com.rdemir.donemprojesi.entities.RandevuSeans;
import com.rdemir.donemprojesi.interfaces.services.IRandevuSablonService;
import com.rdemir.donemprojesi.interfaces.services.IRandevuSeansService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("randevuSeansBean")
@Scope(ScopeName.SESSION)
public class RandevuSeansController {
    @Autowired
    private IRandevuSeansService randevuSeansService;
    @Autowired
    private IRandevuSablonService randevuSablonService;

    private RandevuSeans randevuSeans;
    private RandevuSeans selectedRandevuSeans;
    private RandevuSablon randevuSablon;
    private List<RandevuSablon> randevuSablonList;
    private List<RandevuSeans> randevuSeansList;

    public RandevuSeansController() {
        randevuSeans = new RandevuSeans();
        randevuSablon = new RandevuSablon();
    }

    @PostConstruct
    public void init() {
        randevuSablonList = randevuSablonService.findAll();
        randevuSeansList = randevuSeansService.findAll();
    }

    public void save() {
        randevuSeans.setRandevuSablon(randevuSablon);
        randevuSeansService.save(randevuSeans);
    }

    public void delete() {
        randevuSeansService.delete(randevuSeans.getId());
    }

    public void deleteAll() {
        randevuSeansService.deleteAll();
    }

    public RandevuSeans getRandevuSeans() {
        return randevuSeans;
    }

    public void setRandevuSeans(RandevuSeans randevuSeans) {
        this.randevuSeans = randevuSeans;
    }

    public RandevuSeans getSelectedRandevuSeans() {
        return selectedRandevuSeans;
    }

    public void setSelectedRandevuSeans(RandevuSeans selectedRandevuSeans) {
        this.selectedRandevuSeans = selectedRandevuSeans;
    }

    public RandevuSablon getRandevuSablon() {
        return randevuSablon;
    }

    public void setRandevuSablon(RandevuSablon randevuSablon) {
        this.randevuSablon = randevuSablon;
    }

    public List<RandevuSablon> getRandevuSablonList() {
        return randevuSablonList;
    }

    public void setRandevuSablonList(List<RandevuSablon> randevuSablonList) {
        this.randevuSablonList = randevuSablonList;
    }

    public List<RandevuSeans> getRandevuSeansList() {
        return randevuSeansList;
    }

    public void setRandevuSeansList(List<RandevuSeans> randevuSeansList) {
        this.randevuSeansList = randevuSeansList;
    }


    public void onDcRowSelect(SelectEvent event) {
        selectedRandevuSeans = (RandevuSeans) event.getObject();
        this.randevuSeans = selectedRandevuSeans;
    }
}
