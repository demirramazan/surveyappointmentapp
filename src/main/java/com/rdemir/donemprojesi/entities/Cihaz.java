package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "CIHAZ_TANIM")
public class Cihaz extends BaseEntity<String> {

    @Column(name = "KODU", nullable = false)
    private String kodu;

    @Column(name = "ADI", nullable = false)
    private String adi;

    @Column(name = "AKTIF_MI")
    private Boolean aktifMi;

    @ManyToOne
    @JoinColumn(name = "SALON_ID",
            foreignKey = @ForeignKey(name = "FK_CIHAZ_SALON"))
    private Salon salon;

    public Cihaz() {
    }

    public Cihaz(String kodu, String adi, Boolean aktifMi, Salon salon) {
        this.kodu = kodu;
        this.adi = adi;
        this.aktifMi = aktifMi;
        this.salon = salon;
    }

    public String getKodu() {
        return kodu;
    }

    public void setKodu(String kodu) {
        this.kodu = kodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Boolean getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(Boolean aktifMi) {
        this.aktifMi = aktifMi;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
