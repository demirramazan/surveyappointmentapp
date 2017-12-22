package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "BIRIM")
public class BirimImp extends BaseEntity {


    @Column(name = "BIRIM_KODU")
    private String birimKodu;

    @Column(name = "BIRIM_ADI")
    private String birimAdi;

    @Column(name = "UZUN_ADI")
    private String uzunAdi;

    @Column(name = "AKTIF_MI")
    private Integer aktifMi;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "SALON_ID",
            foreignKey = @ForeignKey(
                    name = "FK_BIRIM_SALON",
                    foreignKeyDefinition = "Birim Rad Salonu"))
    private SalonImp salon;

    public BirimImp() {
    }

    public BirimImp(String birimKodu, String birimAdi, String uzunAdi, Integer aktifMi, SalonImp salon) {
        this.birimKodu = birimKodu;
        this.birimAdi = birimAdi;
        this.uzunAdi = uzunAdi;
        this.aktifMi = aktifMi;
        this.salon = salon;
    }

    public String getBirimKodu() {
        return birimKodu;
    }

    public void setBirimKodu(String birimKodu) {
        this.birimKodu = birimKodu;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public String getUzunAdi() {
        return uzunAdi;
    }

    public void setUzunAdi(String uzunAdi) {
        this.uzunAdi = uzunAdi;
    }

    public Integer getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(Integer aktifMi) {
        this.aktifMi = aktifMi;
    }

    public SalonImp getSalon() {
        return salon;
    }

    public void setSalon(SalonImp salon) {
        this.salon = salon;
    }
}
