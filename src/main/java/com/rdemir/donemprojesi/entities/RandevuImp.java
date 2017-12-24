package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RANDEVU")
public class RandevuImp extends BaseEntity {

    @Column(name = "RANDEVU_TARIHI")
    private Date randevuTarihi;

    @Column(name = "RANDEVU_SAATI")
    private String randevuSaati;

    @ManyToOne
    @JoinColumn(name = "HASTA_TETKIK_ISTEM_DETAY_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_ISTEM_DETAY_ID"))
    private HastaTetkikIstemDetayImp istemDetay;

    @ManyToOne
    @JoinColumn(name = "SALON_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_SALON_ID"))
    private SalonImp salon;

    @ManyToOne
    @JoinColumn(name = "CIHAZ_ID", foreignKey = @ForeignKey(name = "FK_RANDEVU_CIHAZ_ID"))
    private CihazImp cihaz;

    public RandevuImp() {
    }

    public RandevuImp(Date randevuTarihi, String randevuSaati, HastaTetkikIstemDetayImp istemDetay, SalonImp salon, CihazImp cihaz) {
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

    public HastaTetkikIstemDetayImp getIstemDetay() {
        return istemDetay;
    }

    public void setIstemDetay(HastaTetkikIstemDetayImp istemDetay) {
        this.istemDetay = istemDetay;
    }

    public SalonImp getSalon() {
        return salon;
    }

    public void setSalon(SalonImp salon) {
        this.salon = salon;
    }

    public CihazImp getCihaz() {
        return cihaz;
    }

    public void setCihaz(CihazImp cihaz) {
        this.cihaz = cihaz;
    }
}
