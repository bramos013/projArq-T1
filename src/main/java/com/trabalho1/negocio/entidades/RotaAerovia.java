package com.trabalho1.negocio.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.trabalho1.negocio.entidades.classes_associativas.RotaAeroviaPK;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Entity
public class RotaAerovia implements Serializable {

    @EmbeddedId
    private RotaAeroviaPK id; // chave composta

    public RotaAerovia() {
    }

    // Instanciação da relação Aerovia-Rota já criada com adição das respectivas vinculações nas listas de Rotas e Aerovias
    @Autowired
    public RotaAerovia(RotaAeroviaPK id) {
        this.id = id;
        Rota rota = id.getRota();
        Aerovia aerovia = id.getAerovia();
        id.getRota().addAerovia(aerovia);
        id.getAerovia().addRota(rota);
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

    public RotaAeroviaPK getId() {
        return id;
    }

}
