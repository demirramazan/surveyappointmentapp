package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "RANDEVU_SEANS")
public class RandevuSeans extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "RANDEVU_SABLON_ID",
            foreignKey = @ForeignKey(
                    name = "FK_RANDEVU_SEANS_SABLON_ID",
                    foreignKeyDefinition = "Randevu Seans Randevu Şablon"))
    private RandevuSablon randevuSablon;

    @Column(name = "SAAT_BASLANGIC")
    private String saatBaslangic;

    @Column(name = "SAAT_BITIS")
    private String saatBitis;

    @Column(name = "SIRANO")
    private Integer siraNo;

    public RandevuSeans() {
    }

    public RandevuSablon getRandevuSablon() {
        return randevuSablon;
    }

    public void setRandevuSablon(RandevuSablon randevuSablon) {
        this.randevuSablon = randevuSablon;
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

    public Integer getSiraNo() {
        return siraNo;
    }

    public void setSiraNo(Integer siraNo) {
        this.siraNo = siraNo;
    }
}
