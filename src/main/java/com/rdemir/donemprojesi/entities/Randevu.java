package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RANDEVU")
public class Randevu extends BaseEntity {

    @Column(name = "RANDEVU_TARIHI")
    private Date randevuTarihi;

    @Column(name = "RANDEVU_SAATI")
    private String randevuSaati;

    @ManyToOne
    @JoinColumn(name = "HASTA_TETKIK_ISTEM_DETAY_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_ISTEM_DETAY_ID"))
    private HastaTetkikIstemDetay istemDetay;

    @ManyToOne
    @JoinColumn(name = "SALON_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_SALON_ID"))
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "CIHAZ_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_CIHAZ_ID"))
    private Cihaz cihaz;

    public Randevu(Date randevuTarihi, String randevuSaati, HastaTetkikIstemDetay istemDetay, Salon salon, Cihaz cihaz) {
        this.randevuTarihi = randevuTarihi;
        this.randevuSaati = randevuSaati;
        this.istemDetay = istemDetay;
        this.salon = salon;
        this.cihaz = cihaz;
    }

    public Date getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(Date randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
    }

    public String getRandevuSaati() {
        return randevuSaati;
    }

    public void setRandevuSaati(String randevuSaati) {
        this.randevuSaati = randevuSaati;
    }

    public HastaTetkikIstemDetay getIstemDetay() {
        return istemDetay;
    }

    public void setIstemDetay(HastaTetkikIstemDetay istemDetay) {
        this.istemDetay = istemDetay;
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
