package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.util.EnumUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA")
public class Hasta extends BaseEntity {

    @Column(name = "HASTA_ADI")
    private String hastaAdi;

    @Column(name = "HASTA_SOYADI")
    private String hastaSoyadi;

    @Column(name = "CINSIYET")
    private EnumUtil.Cinsiyet cinsiyet;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOGUM_TARIHI")
    private Date dogumTarihi;

    @Column(name = "ANNE_ADI")
    private String anneAdi;

    @Column(name = "BABA_ADI")
    private String babaAdi;

    @Column(name = "HASTA_TELEFON")
    private String telefonNo;

    @Column(name = "HASTA_YAKINI_TELEFON")
    private String hastaYakiniTelefon;

    @Column(name = "HASTA_YAKINLIK_DERECESI")
    private String hastaYakinlikDerecesi;

    @Column(name = "ADRES")
    private String adres;

    public Hasta() {
    }

    public Hasta(String hastaAdi, String hastaSoyadi, EnumUtil.Cinsiyet cinsiyet, Date dogumTarihi, String anneAdi, String babaAdi, String telefonNo, String hastaYakiniTelefon, String hastaYakinlikDerecesi, String adres) {
        this.hastaAdi = hastaAdi;
        this.hastaSoyadi = hastaSoyadi;
        this.cinsiyet = cinsiyet;
        this.dogumTarihi = dogumTarihi;
        this.anneAdi = anneAdi;
        this.babaAdi = babaAdi;
        this.telefonNo = telefonNo;
        this.hastaYakiniTelefon = hastaYakiniTelefon;
        this.hastaYakinlikDerecesi = hastaYakinlikDerecesi;
        this.adres = adres;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }

    public String getHastaSoyadi() {
        return hastaSoyadi;
    }

    public void setHastaSoyadi(String hastaSoyadi) {
        this.hastaSoyadi = hastaSoyadi;
    }

    public EnumUtil.Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(EnumUtil.Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getAnneAdi() {
        return anneAdi;
    }

    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getHastaYakiniTelefon() {
        return hastaYakiniTelefon;
    }

    public void setHastaYakiniTelefon(String hastaYakiniTelefon) {
        this.hastaYakiniTelefon = hastaYakiniTelefon;
    }

    public String getHastaYakinlikDerecesi() {
        return hastaYakinlikDerecesi;
    }

    public void setHastaYakinlikDerecesi(String hastaYakinlikDerecesi) {
        this.hastaYakinlikDerecesi = hastaYakinlikDerecesi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
