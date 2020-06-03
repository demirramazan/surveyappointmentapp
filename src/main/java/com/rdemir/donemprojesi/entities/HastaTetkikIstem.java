package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA_TETKIK_ISTEM")
public class HastaTetkikIstem extends BaseEntity {

    @Column(name = "KABUL_NO")
    private Integer kabulNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "TETKIK_ID",
            foreignKey = @ForeignKey(
                    name = "FK_HASTA_ISTEM_TETKIK_ID"))
    private Tetkik tetkik;

    @Column(name = "MIKTAR")
    private Integer miktar;

    @Column(name = "FIYAT")
    private Double fiyat;

    @Column(name = "ACIKLAMA")
    private String aciklama;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "KABUL_TARIHI")
    private Date kabulTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "KABUL_EDEN_KULLANICI_ID",
            foreignKey = @ForeignKey(
                    name = "FK_ISTEM_KABUL_EDEN_KULLANICI"))
    private User kabulEdenKullanici;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ISTEM_YAPAN_PERSONEL_ID",
            foreignKey = @ForeignKey(
                    name = "FK_ISTEM_YAPAN_PERSONEL_ID"))
    private Personel istemYapanPersonel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "KABUL_YAPAN_TEKNISYEN_ID",
            foreignKey = @ForeignKey(
                    name = "FK_KABUL_YAPAN_TEKNISYEN_ID"))
    private Personel kabulYapanTeknisyen;


    public HastaTetkikIstem() {
    }

    public HastaTetkikIstem(Integer kabulNo, Tetkik tetkik, Integer miktar, Double fiyat, String aciklama, Date kabulTarihi, User kabulEdenKullanici, Personel istemYapanPersonel, Personel kabulYapanTeknisyen) {
        this.kabulNo = kabulNo;
        this.tetkik = tetkik;
        this.miktar = miktar;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
        this.kabulTarihi = kabulTarihi;
        this.kabulEdenKullanici = kabulEdenKullanici;
        this.istemYapanPersonel = istemYapanPersonel;
        this.kabulYapanTeknisyen = kabulYapanTeknisyen;
    }

    public Integer getKabulNo() {
        return kabulNo;
    }

    public void setKabulNo(Integer kabulNo) {
        this.kabulNo = kabulNo;
    }

    public Tetkik getTetkik() {
        return tetkik;
    }

    public void setTetkik(Tetkik tetkik) {
        this.tetkik = tetkik;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }


    public Date getKabulTarihi() {
        return kabulTarihi;
    }

    public void setKabulTarihi(Date kabulTarihi) {
        this.kabulTarihi = kabulTarihi;
    }

    public User getKabulEdenKullanici() {
        return kabulEdenKullanici;
    }

    public void setKabulEdenKullanici(User kabulEdenKullanici) {
        this.kabulEdenKullanici = kabulEdenKullanici;
    }

    public Personel getIstemYapanPersonel() {
        return istemYapanPersonel;
    }

    public void setIstemYapanPersonel(Personel istemYapanPersonel) {
        this.istemYapanPersonel = istemYapanPersonel;
    }

    public Personel getKabulYapanTeknisyen() {
        return kabulYapanTeknisyen;
    }

    public void setKabulYapanTeknisyen(Personel kabulYapanTeknisyen) {
        this.kabulYapanTeknisyen = kabulYapanTeknisyen;
    }

}
