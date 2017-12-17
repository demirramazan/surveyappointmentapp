package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.IBirim;

import javax.persistence.*;

@Entity
@Table(name = "BIRIM")
public class BirimImp extends BaseEntity implements IBirim {


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

    @Override
    public String getBirimKodu() {
        return birimKodu;
    }

    public void setBirimKodu(String birimKodu) {
        this.birimKodu = birimKodu;
    }

    @Override
    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    @Override
    public String getUzunAdi() {
        return uzunAdi;
    }

    public void setUzunAdi(String uzunAdi) {
        this.uzunAdi = uzunAdi;
    }

    @Override
    public Integer getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(Integer aktifMi) {
        this.aktifMi = aktifMi;
    }

    @Override
    public SalonImp getSalon() {
        return salon;
    }

    public void setSalon(SalonImp salon) {
        this.salon = salon;
    }
}
