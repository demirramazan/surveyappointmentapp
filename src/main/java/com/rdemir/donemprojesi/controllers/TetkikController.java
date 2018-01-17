package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Salon;
import com.rdemir.donemprojesi.entities.Tetkik;
import com.rdemir.donemprojesi.interfaces.services.ITetkikService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("tetkikBean")
@Scope(ScopeName.REQUEST)
public class TetkikController {
    @Autowired
    private ITetkikService tetkikService;

    private Tetkik tetkik;
    private Tetkik selectedTetkik;
    private Salon salon;
    private List<Tetkik> tetkikList;

    public TetkikController() {
        this.tetkik = new Tetkik();
    }

    @PostConstruct
    public void init() {
        tetkikList = getTetkikler();
    }

    public void save() {
        tetkik.setSalon(salon);
        tetkikService.save(tetkik);
    }

    public void delete() {
        tetkikService.delete(tetkik.getId());
    }

    public List<Tetkik> getTetkikler() {
        return tetkikService.getTetkikList();
    }


    public Tetkik getTetkik() {
        return tetkik;
    }

    public void setTetkik(Tetkik tetkik) {
        this.tetkik = tetkik;
    }

    public Tetkik getSelectedTetkik() {
        return selectedTetkik;
    }

    public void setSelectedTetkik(Tetkik selectedTetkik) {
        this.selectedTetkik = selectedTetkik;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Tetkik> getTetkikList() {
        return tetkikList;
    }

    public void setTetkikList(List<Tetkik> tetkikList) {
        this.tetkikList = tetkikList;
    }

    public void reset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlPanelGrid panelGrid = (HtmlPanelGrid) facesContext.getViewRoot().findComponent(":FRMCihz:chzPg");
        panelGrid.clearInitialState();
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedTetkik = (Tetkik) event.getObject();
        this.tetkik = selectedTetkik;
    }
}
