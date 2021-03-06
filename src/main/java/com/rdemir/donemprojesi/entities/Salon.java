package com.rdemir.donemprojesi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "SALON_TANIM")
public class Salon extends BaseEntity {

    @Column(name = "SALON_KODU")
    private String salonKodu;

    @Column(name = "SALON_ADI")
    private String salonAdi;

    @OneToMany(mappedBy = "salon")
    private List<Cihaz> cihaz;

    public Salon() {
    }

    public Salon(String salonKodu, String salonAdi, List<Cihaz> cihaz) {
        this.salonKodu = salonKodu;
        this.salonAdi = salonAdi;
        this.cihaz = cihaz;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getSalonKodu() {
        return salonKodu;
    }

    public void setSalonKodu(String salonKodu) {
        this.salonKodu = salonKodu;
    }

    public String getSalonAdi() {
        return salonAdi;
    }

    public void setSalonAdi(String salonAdi) {
        this.salonAdi = salonAdi;
    }

    public List<Cihaz> getCihaz() {
        return cihaz;
    }

    public void setCihaz(List<Cihaz> cihaz) {
        this.cihaz = cihaz;
    }
}
