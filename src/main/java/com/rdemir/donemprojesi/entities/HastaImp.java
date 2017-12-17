package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.IHasta;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HASTA")
public class HastaImp extends BaseEntity implements IHasta {

    private String hastaAdi;

    private String hastaSoyadi;

    private Integer cinsiyet;

    private Date dogumTarihi;

    private String anneAdi;

    private String babaAdi;

    private String telefonNo;


}
