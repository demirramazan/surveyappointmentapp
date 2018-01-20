package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Randevu;
import com.rdemir.donemprojesi.interfaces.services.IHastaRandevuService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("randevuBean")
@Scope(ScopeName.SESSION)
public class RandevuController {
    @Autowired
    private IHastaRandevuService hastaRandevuService;

    private Randevu randevu;
    private Randevu selectedRandevu;
    private List<Randevu> randevuList;


    public RandevuController() {
        randevu = new Randevu();
    }

    @PostConstruct
    public void init() {
        randevuList = hastaRandevuService.findAll();
    }

    public void save() {
        hastaRandevuService.save(randevu);
    }

    public void delete() {
        hastaRandevuService.delete(randevu.getId());
    }

    public Randevu getRandevu() {
        return randevu;
    }

    public void setRandevu(Randevu randevu) {
        this.randevu = randevu;
    }

    public Randevu getSelectedRandevu() {
        return selectedRandevu;
    }

    public void setSelectedRandevu(Randevu selectedRandevu) {
        this.selectedRandevu = selectedRandevu;
    }

    public List<Randevu> getRandevuList() {
        return randevuList;
    }

    public void setRandevuList(List<Randevu> randevuList) {
        this.randevuList = randevuList;
    }
}
