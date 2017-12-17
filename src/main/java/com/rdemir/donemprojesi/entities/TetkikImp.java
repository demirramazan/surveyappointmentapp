package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.ITetkik;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TETKIK_TANIM")
public class TetkikImp extends BaseEntity implements ITetkik {
}
