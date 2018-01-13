package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HASTA_ISLEM")
public class HastaIslem extends BaseEntity {

    @Column(name = "KAYIT_TARIH_SAATI", nullable = false)
    private Date kayitTarihSaati;

    @Column(name = "BASVURU_NO", nullable = false)
    private Integer basvuruNo;

    @ManyToOne
    @JoinColumn(name = "HASTA_ID", foreignKey = @ForeignKey(name = "FK_HASTA_ISLEM_HASTA"))
    private Hasta hasta;


}
