package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA_BASVURU")
public class HastaBasvuru extends BaseEntity {

    @Column(name = "BASVURU_NO", nullable = false)
    private Integer basvuruNo;

    @ManyToOne
    @JoinColumn(name = "HASTA_ID",
            foreignKey = @ForeignKey(name = "FK_HASTA_ISLEM_HASTA_ID"))
    private Hasta hasta;

    @Column(name = "HASTA_KURUM")
    private String hastaKurum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BASVURU_TARIHI")
    private Date basvuruTarihi;

    @Column(name = "ONCELIK")
    private String oncelik;

    @Column(name = "ACIKLAMA")
    private String aciklama;

    public HastaBasvuru() {
    }

    public HastaBasvuru(Integer basvuruNo, Hasta hasta, String hastaKurum, Date basvuruTarihi, String oncelik, String aciklama) {
        this.basvuruNo = basvuruNo;
        this.hasta = hasta;
        this.hastaKurum = hastaKurum;
        this.basvuruTarihi = basvuruTarihi;
        this.oncelik = oncelik;
        this.aciklama = aciklama;
    }

    public Integer getBasvuruNo() {
        return basvuruNo;
    }

    public void setBasvuruNo(Integer basvuruNo) {
        this.basvuruNo = basvuruNo;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public String getHastaKurum() {
        return hastaKurum;
    }

    public void setHastaKurum(String hastaKurum) {
        this.hastaKurum = hastaKurum;
    }

    public Date getBasvuruTarihi() {
        return basvuruTarihi;
    }

    public void setBasvuruTarihi(Date basvuruTarihi) {
        this.basvuruTarihi = basvuruTarihi;
    }

    public String getOncelik() {
        return oncelik;
    }

    public void setOncelik(String oncelik) {
        this.oncelik = oncelik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
