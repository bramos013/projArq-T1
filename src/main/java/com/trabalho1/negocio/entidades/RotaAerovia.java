package com.trabalho1.negocio.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.trabalho1.negocio.entidades.classes_associativas.RotaAeroviaPK;

@Entity
public class RotaAerovia {

    @EmbeddedId
    private RotaAeroviaPK id = new RotaAeroviaPK(); // chave composta 

    public RotaAerovia() {
    }

    public RotaAerovia(RotaAeroviaPK id) {
        this.id = id;
    }

    public Rota getRota() {
        return id.getRota();
    }

    public void setRota(Rota rota) {
        id.setRota(rota);
    }

    public Aerovia getAerovia() {
        return id.getAerovia();
    }

    public void setAerovia(Aerovia aerovia) {
        id.setAerovia(aerovia);
    }
    
}
