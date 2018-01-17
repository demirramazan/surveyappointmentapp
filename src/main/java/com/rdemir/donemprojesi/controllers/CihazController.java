package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Cihaz;
import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.interfaces.services.ICihazService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("cihazBean")
@Scope(ScopeName.SESSION)
public class CihazController {
    @Autowired
    private ICihazService cihazService;

    private Cihaz cihaz;
    private Cihaz selectedCihaz;
    private Salon salon;
    private List<Cihaz> cihazList;

    public CihazController() {
        this.cihaz = new Cihaz();
    }

    @PostConstruct
    public void init() {
        cihazList = getSalonlar();
    }

    public void save() {
        cihaz.setSalon(salon);
        cihazService.save(cihaz);
    }

    public void delete() {
        cihazService.delete(cihaz.getId());
    }

    public List<Cihaz> getSalonlar() {
        return cihazService.getCihazList();
    }

    public void reset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlPanelGrid panelGrid = (HtmlPanelGrid) facesContext.getViewRoot().findComponent(":FRMCihz:chzPg");
        panelGrid.clearInitialState();
    }

    public Cihaz getCihaz() {
        return cihaz;
    }

    public void setCihaz(Cihaz cihaz) {
        this.cihaz = cihaz;
    }

    public Cihaz getSelectedCihaz() {
        return selectedCihaz;
    }

    public void setSelectedCihaz(Cihaz selectedCihaz) {
        this.selectedCihaz = selectedCihaz;
    }

    public List<Cihaz> getCihazList() {
        return cihazList;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public void setCihazList(List<Cihaz> cihazList) {
        this.cihazList = cihazList;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedCihaz = (Cihaz) event.getObject();
        this.cihaz = selectedCihaz;
    }

}
