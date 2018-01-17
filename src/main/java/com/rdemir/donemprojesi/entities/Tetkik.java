package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "TETKIK_TANIM")
public class Tetkik extends BaseEntity {

    @Column(name = "TETKIK_KODU")
    private String tetkikKodu;

    @Column(name = "TETKIK_ADI")
    private String tetkikAdi;

    @Column(name = "AKTIF_MI")
    private Boolean aktifMi;

    @Column(name = "FIYAT")
    private Integer fiyat;

    @Column(name = "PUAN")
    private Integer puan;

    @ManyToOne
    @JoinColumn(name = "SALON_ID",
            foreignKey = @ForeignKey(name = "FK_TETKIK_SALON_ID"))
    private Salon salon;

    public Tetkik() {
    }

    public Tetkik(String tetkikKodu, String tetkikAdi, Boolean aktifMi, Integer fiyat, Integer puan, Salon salon) {
        this.tetkikKodu = tetkikKodu;
        this.tetkikAdi = tetkikAdi;
        this.aktifMi = aktifMi;
        this.fiyat = fiyat;
        this.puan = puan;
        this.salon = salon;
    }

    public Integer getPuan() {
        return puan;
    }

    public void setPuan(Integer puan) {
        this.puan = puan;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public Boolean getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(Boolean aktifMi) {
        this.aktifMi = aktifMi;
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
