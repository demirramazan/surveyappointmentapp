package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Birim;
import com.rdemir.donemprojesi.entities.Personel;
import com.rdemir.donemprojesi.interfaces.services.IPersonelService;
import com.rdemir.donemprojesi.util.ScopeUtil;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("personelBean")
@Scope(ScopeUtil.SESSION)
public class PersonelController {
    @Autowired
    private IPersonelService personelService;

    private Personel personel;
    private Personel selectedPersonel;
    private List<Personel> personelList;
    private Birim birim;

    @PostConstruct
    public void init() {
        personelList = getPersonelList();
    }

    public PersonelController() {
        personel = new Personel();
    }

    public void save() {
        personel.setBirim(birim);
        personelService.save(personel);
    }

    public void delete() {
        personelService.delete(personel.getId());
    }

    public List<Personel> getPersonelList() {
        return personelService.getPersonelList();
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Personel getSelectedPersonel() {
        return selectedPersonel;
    }

    public void setSelectedPersonel(Personel selectedPersonel) {
        this.selectedPersonel = selectedPersonel;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public void reset() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HtmlPanelGrid panelGrid = (HtmlPanelGrid) facesContext.getViewRoot().findComponent(":FRMCihz:chzPg");
        panelGrid.clearInitialState();
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedPersonel = (Personel) event.getObject();
        this.personel = selectedPersonel;
    }
}
