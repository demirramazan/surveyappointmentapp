package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Birim;
import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.interfaces.services.IBirimService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("birimBean")
@Scope(ScopeName.SESSION)
public class BirimController {
    @Autowired
    private IBirimService birimService;

    private Birim birim;
    private Salon salon;
    private Birim selectedBirim;
    private List<Birim> birimList;

    public BirimController() {
        this.birim = new Birim();
    }

    @PostConstruct
    public void init() {
        birimList = getBirimList();
    }


    public void save() {
        birim.setSalon(salon);
        birimService.save(birim);
    }

    public void delete() {
        birimService.delete(birim.getId());
    }

    public List<Birim> getBirimList() {
        return birimService.getBirimList();
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Birim getSelectedBirim() {
        return selectedBirim;
    }

    public void setSelectedBirim(Birim selectedBirim) {
        this.selectedBirim = selectedBirim;
    }

    public void setBirimList(List<Birim> birimList) {
        this.birimList = birimList;
    }

    public void reset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlPanelGrid panelGrid = (HtmlPanelGrid) facesContext.getViewRoot().findComponent(":FRMBrm:brmPg");
        panelGrid.clearInitialState();
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedBirim = (Birim) event.getObject();
        this.birim = selectedBirim;
    }
}
