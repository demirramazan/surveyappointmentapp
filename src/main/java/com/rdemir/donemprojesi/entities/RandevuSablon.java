package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "RANDEVU_SABLON")
public class RandevuSablon extends BaseEntity {

    @Column(name = "DURUM")
    private Integer durum;

    @Column(name = "AD")
    private String ad;

    @Column(name = "SAAT_BASLANGIC")
    private String saatBaslangic;

    @Column(name = "SAAT_BITIS")
    private String saatBitis;

    @Column(name = "SAAT_OGLEN_BASLANGIC")
    private String saatOglenBaslangic;

    @Column(name = "SAAT_OGLEN_BITIS")
    private String saatOglenBitis;

    @Column(name = "RANDEVU_SURESI")
    private Integer randevuSuresi;

    @ManyToOne
    @JoinColumn(name = "SALON_ID",
            foreignKey =
            @ForeignKey(name = "FK_RANDEVU_SABLON_SALON_ID"))
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "CIHAZ_ID",
            foreignKey =
            @ForeignKey(name = "FK_RANDEVU_SABLON_CIHAZ_ID"))
    private Cihaz cihaz;

    public RandevuSablon() {
    }

    public RandevuSablon(Integer durum, String ad, String saatBaslangic, String saatBitis, String saatOglenBaslangic, String saatOglenBitis, Integer randevuSuresi, Salon salon, Cihaz cihaz) {
        this.durum = durum;
        this.ad = ad;
        this.saatBaslangic = saatBaslangic;
        this.saatBitis = saatBitis;
        this.saatOglenBaslangic = saatOglenBaslangic;
        this.saatOglenBitis = saatOglenBitis;
        this.randevuSuresi = randevuSuresi;
        this.salon = salon;
        this.cihaz = cihaz;
    }

    public Integer getDurum() {
        return durum;
    }

    public void setDurum(Integer durum) {
        this.durum = durum;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSaatBaslangic() {
        return saatBaslangic;
    }

    public void setSaatBaslangic(String saatBaslangic) {
        this.saatBaslangic = saatBaslangic;
    }

    public String getSaatBitis() {
        return saatBitis;
    }

    public void setSaatBitis(String saatBitis) {
        this.saatBitis = saatBitis;
    }

    public String getSaatOglenBaslangic() {
        return saatOglenBaslangic;
    }

    public void setSaatOglenBaslangic(String saatOglenBaslangic) {
        this.saatOglenBaslangic = saatOglenBaslangic;
    }

    public String getSaatOglenBitis() {
        return saatOglenBitis;
    }

    public void setSaatOglenBitis(String saatOglenBitis) {
        this.saatOglenBitis = saatOglenBitis;
    }

    public Integer getRandevuSuresi() {
        return randevuSuresi;
    }

    public void setRandevuSuresi(Integer randevuSuresi) {
        this.randevuSuresi = randevuSuresi;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Cihaz getCihaz() {
        return cihaz;
    }

    public void setCihaz(Cihaz cihaz) {
        this.cihaz = cihaz;
    }
}
