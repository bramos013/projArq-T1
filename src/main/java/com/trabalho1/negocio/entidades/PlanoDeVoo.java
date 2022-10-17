package com.trabalho1.negocio.entidades;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

@Entity
public class PlanoDeVoo implements Serializable {
    @Id
    private String idVoo;
    private Instant data;
    private float altitude;
    private float velCruzeiro;

    // Associação - 1 plano de voo corresponde a 1 aeronave
    @OneToOne
    private Aeronave aeronave;
    // Associação - 1 plano de voo utiliza 1 rota, 1 rota pode ser utilizada por N planos de voos
    @ManyToOne
    private Rota rota;

    public PlanoDeVoo(String idVoo, Instant data, float altitude, Rota rota, float velCruzeiro) {
        this.idVoo = idVoo;
        this.data = data;
        this.altitude = altitude;
        this.rota = rota;
        this.velCruzeiro = velCruzeiro;
    }

    public String getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(String idVoo) {
        this.idVoo = idVoo;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public float getVelCruzeiro() {
        return velCruzeiro;
    }

    public void setVelCruzeiro(float velCruzeiro) {
        this.velCruzeiro = velCruzeiro;
    }

    @Override
    public String toString() {
        return "PlanoDeVoo{" +
                "idVoo='" + idVoo + '\'' +
                ", data=" + data +
                ", altitude=" + altitude +
                ", rota=" + rota +
                ", velCruzeiro=" + velCruzeiro +
                '}';
    }
}