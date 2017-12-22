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


}
