package com.trabalho1.negocio.entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "planos_de_voo")
public class PlanoDeVoo implements Serializable {

    @Serial
    private static final long serialVersionUID = 4788874478874108911L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String idVoo;
    private float altitude;
    private LocalDate data;
    private float velCruzeiro;


    @OneToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;

    public PlanoDeVoo(String idVoo, LocalDate data, float altitude, Rota rota, float velCruzeiro) {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
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