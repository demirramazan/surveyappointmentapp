package com.rdemir.donemprojesi.entities;


import com.rdemir.donemprojesi.util.Cinsiyet;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "HASTA")
public class Hasta extends BaseEntity {

    @Column(name = "HASTA_ADI")
    private String hastaAdi;

    @Column(name = "HASTA_SOYADI")
    private String hastaSoyadi;

    @Column(name = "CINSIYET")
    @Enumerated(value = EnumType.STRING)
    private Cinsiyet cinsiyet;

    @Column(name = "HASTA_KIMLIK_NO")
    @Size(max = 11)
    private String hastaKimlikNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOGUM_TARIHI")
    private Date dogumTarihi;

    @Column(name = "DOGUM_YERI")
    private String dogumYeri;

    @Column(name = "ANNE_ADI")
    private String anneAdi;

    @Column(name = "BABA_ADI")
    private String babaAdi;

    @Column(name = "HASTA_CEP_TELEFON")
    @Size(max = 10)
    private String hastaCepTelefonu;

    @Column(name = "HASTA_EV_TELEFON")
    @Size(max = 10)
    private String hastaEvTelefonu;

    @Column(name = "HASTA_YAKINI_TELEFON")
    private String hastaYakiniTelefon;

    @Column(name = "HASTA_YAKINLIK_DERECESI")
    private String hastaYakinlikDerecesi;

    @Column(name = "ADRES", length = 1000)
    private String adres;

    @Column(name = "KAN_GRUBU")
    private String kanGrubu;

    @Column(name = "HASTA_EMAIL")
    private String hastaEmail;

    @Column(name = "HASTA_MEDENI_HALI")
    private String hastaMedeniHali;

    public Hasta() {
    }

    public Hasta(String hastaAdi, String hastaSoyadi, String hastaKimlikNo, Cinsiyet cinsiyet, Date dogumTarihi, String anneAdi, String babaAdi,
                 String hastaCepTelefonu, String hastaEvTelefonu, String kanGrubu, String hastaYakiniTelefon, String hastaYakinlikDerecesi, String adres, String hastaMedeniHali) {
        this.hastaAdi = hastaAdi;
        this.hastaSoyadi = hastaSoyadi;
        this.hastaKimlikNo = hastaKimlikNo;
        this.cinsiyet = cinsiyet;
        this.dogumTarihi = dogumTarihi;
        this.anneAdi = anneAdi;
        this.babaAdi = babaAdi;
        this.hastaCepTelefonu = hastaCepTelefonu;
        this.hastaEvTelefonu = hastaEvTelefonu;
        this.hastaYakiniTelefon = hastaYakiniTelefon;
        this.hastaYakinlikDerecesi = hastaYakinlikDerecesi;
        this.adres = adres;
        this.kanGrubu = kanGrubu;
        this.hastaMedeniHali = hastaMedeniHali;
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

    public String getHastaKimlikNo() {
        return hastaKimlikNo;
    }

    public void setHastaKimlikNo(String hastaKimlikNo) {
        this.hastaKimlikNo = hastaKimlikNo;
    }

    public String getHastaEmail() {
        return hastaEmail;
    }

    public void setHastaEmail(String hastaEmail) {
        this.hastaEmail = hastaEmail;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
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

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getHastaCepTelefonu() {
        return hastaCepTelefonu;
    }

    public void setHastaCepTelefonu(String hastaCepTelefonu) {
        this.hastaCepTelefonu = hastaCepTelefonu;
    }

    public String getHastaEvTelefonu() {
        return hastaEvTelefonu;
    }

    public void setHastaEvTelefonu(String hastaEvTelefonu) {
        this.hastaEvTelefonu = hastaEvTelefonu;
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

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }
}
