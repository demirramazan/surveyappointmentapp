package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RANDEVU")
public class Randevu extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BASLANGIC_TARIHI")
    private Date baslangicTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BITIS_TARIHI")
    private Date bitisTarihi;

    @OneToOne
    @JoinColumn(name = "HASTA_TETKIK_ISTEM_ID",
            foreignKey =
            @ForeignKey(name = "FK_RANDEVU_ISTEM_DETAY_ID"))
    private HastaTetkikIstem istem;

    @ManyToOne
    @JoinColumn(name = "SALON_ID",
            foreignKey =
            @ForeignKey(name = "FK_RANDEVU_SALON_ID"))
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "CIHAZ_ID",
            foreignKey =
            @ForeignKey(name = "FK_RANDEVU_CIHAZ_ID"))
    private Cihaz cihaz;

    @Column(name = "RANDEVU_DURUMU")
    private String randevuDurumu;

    public Randevu() {
    }

    public Randevu(Date baslangicTarihi, Date bitisTarihi, HastaTetkikIstem istem, Salon salon, Cihaz cihaz, String randevuDurumu) {
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.istem = istem;
        this.salon = salon;
        this.cihaz = cihaz;
        this.randevuDurumu = randevuDurumu;
    }

    public String getRandevuDurumu() {
        return randevuDurumu;
    }

    public void setRandevuDurumu(String randevuDurumu) {
        this.randevuDurumu = randevuDurumu;
    }

    public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public HastaTetkikIstem getIstem() {
        return istem;
    }

    public void setIstem(HastaTetkikIstem istem) {
        this.istem = istem;
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
