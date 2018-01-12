package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "TETKIK_TANIM")
public class Tetkik extends BaseEntity {

    @Column(name = "TETKIK_KODU")
    private String tetkikKodu;

    @Column(name = "TETKIK_ADI")
    private String tetkikAdi;

    @ManyToOne
    @JoinColumn(name = "SALON_ID", foreignKey = @ForeignKey(name = "FK_TETKIK_SALON_ID"))
    private Salon salon;

    public Tetkik() {
    }

    public Tetkik(String tetkikKodu, String tetkikAdi, Salon salon) {
        this.tetkikKodu = tetkikKodu;
        this.tetkikAdi = tetkikAdi;
        this.salon = salon;
    }

    public String getTetkikKodu() {
        return tetkikKodu;
    }

    public void setTetkikKodu(String tetkikKodu) {
        this.tetkikKodu = tetkikKodu;
    }

    public String getTetkikAdi() {
        return tetkikAdi;
    }

    public void setTetkikAdi(String tetkikAdi) {
        this.tetkikAdi = tetkikAdi;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
