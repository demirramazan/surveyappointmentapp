package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "CIHAZ_TANIM")
public class CihazImp extends BaseEntity {

    @Column(name = "KODU", nullable = false)
    String kodu;

    @Column(name = "ADI", nullable = false)
    String adi;

    @Column(name = "AKTIF_MI")
    private Integer aktifMi;

    @ManyToOne
    @JoinColumn(name = "SALON_ID",
            foreignKey = @ForeignKey(name = "FK_CIHAZ_SALON"))
    private SalonImp salon;

    public CihazImp() {
    }

    public CihazImp(String kodu, String adi, Integer aktifMi, SalonImp salon) {
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

    public Integer getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(Integer aktifMi) {
        this.aktifMi = aktifMi;
    }

    public SalonImp getSalon() {
        return salon;
    }

    public void setSalon(SalonImp salon) {
        this.salon = salon;
    }
}
