package com.trabalho1.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

@Entity
public class PlanoDeVoo implements Serializable {

    @Serial
    private static final long serialVersionUID = 4788874478874108911L;

    @Id
    private String idVoo;
    private float altitude;
    private Instant data;
    private float velCruzeiro;

    // Associação - 1 plano de voo corresponde a 1 aeronave
    @OneToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    public PlanoDeVoo(String idVoo, Instant data, float altitude, Rota rota, float velCruzeiro) {
        this.idVoo = idVoo;
        this.data = data;
        this.altitude = altitude;
        this.velCruzeiro = velCruzeiro;
    }

    public PlanoDeVoo() {

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
                ", velCruzeiro=" + velCruzeiro +
                '}';
    }
}