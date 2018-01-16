package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.interfaces.services.ISalonService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("salonBean")
@Scope(ScopeName.SESSION)
public class SalonController {

    @Autowired
    private ISalonService salonService;

    private Salon salon;
    private Salon selectedSalon;
    private List<Salon> salonList;

    public SalonController() {
        this.salon = new Salon();
    }

    @PostConstruct
    public void init() {
        salonList = getSalonlar();
    }

    public void saveSalon() {
        salonService.save(salon);
    }

    public void delete() {
        salonService.delete(salon.getId());
    }

    public List<Salon> getSalonlar() {
        return salonService.getSalonList();
    }

    public Salon getSalon() {
        return salon;
    }

    public void reset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        PanelGrid panelGrid = (PanelGrid) facesContext.getViewRoot().findComponent(":FRMSln:slnPG");
        panelGrid.clearInitialState();
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Salon getSelectedSalon() {
        return selectedSalon;
    }

    public void setSelectedSalon(Salon selectedSalon) {
        this.selectedSalon = selectedSalon;
    }

    public List<Salon> getSalonList() {
        return salonList;
    }

    public void setSalonList(List<Salon> salonList) {
        this.salonList = salonList;
    }

    public void onRowSelect(SelectEvent event) {
        selectedSalon = (Salon) event.getObject();
        this.salon = selectedSalon;
    }

}
