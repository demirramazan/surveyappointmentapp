package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA_BASVURU_DETAY")
public class HastaBasvuruDetay extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "HASTA_BASVURU_ID",
            foreignKey = @ForeignKey(
                    name = "FK_HASTA_BASVURU"))
    private HastaBasvuru hastaBasvuru;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "BIRIM_ID",
            foreignKey = @ForeignKey(
                    name = "FK_HASTA_BIRIM_KAYIT_BIRIM"))
    private Birim birim;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "PERSONEL_ID",
            foreignKey = @ForeignKey(
                    name = "FK_HASTA_BIRIM_KAYIT_PERSONEL"))
    private Personel personel;

    @Column(name = "MUAYENE_YAPILDI_MI")
    private Integer muayeneYapildiMi;

    @Column(name = "SIRA_NUMARASI")
    private Integer siraNumarasi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GELIS_TARIHI")
    private Date gelisTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CIKIS_TARIH")
    private Date cikisTarih;

    public HastaBasvuruDetay() {
    }

    public HastaBasvuruDetay(HastaBasvuru hastaBasvuru, Birim birim, Personel personel, Integer muayeneYapildiMi,
                             Integer siraNumarasi, Date gelisTarihi, Date cikisTarih) {
        this.hastaBasvuru = hastaBasvuru;
        this.birim = birim;
        this.personel = personel;
        this.muayeneYapildiMi = muayeneYapildiMi;
        this.siraNumarasi = siraNumarasi;
        this.gelisTarihi = gelisTarihi;
        this.cikisTarih = cikisTarih;
    }

    public HastaBasvuru getHastaBasvuru() {
        return hastaBasvuru;
    }

    public void setHastaBasvuru(HastaBasvuru hastaBasvuru) {
        this.hastaBasvuru = hastaBasvuru;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Integer getMuayeneYapildiMi() {
        return muayeneYapildiMi;
    }

    public void setMuayeneYapildiMi(Integer muayeneYapildiMi) {
        this.muayeneYapildiMi = muayeneYapildiMi;
    }

    public Integer getSiraNumarasi() {
        return siraNumarasi;
    }

    public void setSiraNumarasi(Integer siraNumarasi) {
        this.siraNumarasi = siraNumarasi;
    }

    public Date getGelisTarihi() {
        return gelisTarihi;
    }

    public void setGelisTarihi(Date gelisTarihi) {
        this.gelisTarihi = gelisTarihi;
    }

    public Date getCikisTarih() {
        return cikisTarih;
    }

    public void setCikisTarih(Date cikisTarih) {
        this.cikisTarih = cikisTarih;
    }
}
