package com.trabalho1.negocio.entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "aeronaves")
public class Aeronave implements Serializable {

    @Serial
    private static final long serialVersionUID = 3688596407717696423L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prefixo;
    private int velocidadeCruzeiro;
    private int autonomia;

    public Aeronave(String prefixo, int autonomia, int velocidadeCruzeiro) {
        this.prefixo = prefixo;
        this.autonomia = autonomia;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public Aeronave() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public void setVelocidadeCruzeiro(int velocidadeCruzeiro) {
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prefixo == null) ? 0 : prefixo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aeronave other = (Aeronave) obj;
        if (prefixo == null) {
            if (other.prefixo != null)
                return false;
        } else if (!prefixo.equals(other.prefixo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aeronave [prefixo=" + prefixo + ", autonomia=" + autonomia + ", velocidadeCruzeiro="
                + velocidadeCruzeiro + "]";
    }

}
