package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA_TETKIK_RAPOR")
public class HastaTetkikRapor extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ONAY_YAPAN_UZMAN_ID",
            foreignKey = @ForeignKey(
                    name = "FK_ONAY_YAPAN_UZMAN_ID"))
    private Personel onayYapanUzman;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ONAY_TARIHI")
    private Date onayTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAPOR_TARIHI")
    private Date raporTarihi;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ONAYLAYAN_KULLANICI_ID",
            foreignKey = @ForeignKey(
                    name = "FK_ISTEM_ONAYLAYAN_KULLANICI"))
    private User onaylayanKullanici;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "HASTA_TETKIK_ISTEM_ID",
            foreignKey = @ForeignKey(
                    name = "FK_HASTA_TETKIK_ISTEM_ID"))
    private HastaTetkikIstem hastaTetkikIstem;

    @Lob
    @Column(name = "SONUC")
    private String sonuc;

    @Column(name = "RAPOR_ONAYLI_MI")
    private Integer raporOnayliMi;

    public HastaTetkikRapor() {
    }

    public HastaTetkikRapor(Personel onayYapanUzman, Date onayTarihi, Date raporTarihi, User onaylayanKullanici, HastaTetkikIstem hastaTetkikIstem, String sonuc, Integer raporOnayliMi) {
        this.onayYapanUzman = onayYapanUzman;
        this.onayTarihi = onayTarihi;
        this.raporTarihi = raporTarihi;
        this.onaylayanKullanici = onaylayanKullanici;
        this.hastaTetkikIstem = hastaTetkikIstem;
        this.sonuc = sonuc;
        this.raporOnayliMi = raporOnayliMi;
    }

    public Personel getOnayYapanUzman() {
        return onayYapanUzman;
    }

    public void setOnayYapanUzman(Personel onayYapanUzman) {
        this.onayYapanUzman = onayYapanUzman;
    }

    public Date getRaporTarihi() {
        return raporTarihi;
    }

    public void setRaporTarihi(Date raporTarihi) {
        this.raporTarihi = raporTarihi;
    }

    public HastaTetkikIstem getHastaTetkikIstem() {
        return hastaTetkikIstem;
    }

    public void setHastaTetkikIstem(HastaTetkikIstem hastaTetkikIstem) {
        this.hastaTetkikIstem = hastaTetkikIstem;
    }

    public Date getOnayTarihi() {
        return onayTarihi;
    }

    public void setOnayTarihi(Date onayTarihi) {
        this.onayTarihi = onayTarihi;
    }

    public User getOnaylayanKullanici() {
        return onaylayanKullanici;
    }

    public void setOnaylayanKullanici(User onaylayanKullanici) {
        this.onaylayanKullanici = onaylayanKullanici;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public Integer getRaporOnayliMi() {
        return raporOnayliMi;
    }

    public void setRaporOnayliMi(Integer raporOnayliMi) {
        this.raporOnayliMi = raporOnayliMi;
    }
}
