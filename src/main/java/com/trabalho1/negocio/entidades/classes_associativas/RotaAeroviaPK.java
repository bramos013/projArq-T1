package com.trabalho1.negocio.entidades.classes_associativas;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.entidades.Rota;

import java.io.Serializable;

@Embeddable
public class RotaAeroviaPK implements Serializable {

    @ManyToOne
    private Rota rota;

    @ManyToOne
    private Aerovia aerovia;

    public RotaAeroviaPK() {
    }

    public RotaAeroviaPK(Rota rota, Aerovia aerovia) {
        this.rota = rota;
        this.aerovia = aerovia;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Aerovia getAerovia() {
        return aerovia;
    }

    public void setAerovia(Aerovia aerovia) {
        this.aerovia = aerovia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aerovia == null) ? 0 : aerovia.hashCode());
        result = prime * result + ((rota == null) ? 0 : rota.hashCode());
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
        RotaAeroviaPK other = (RotaAeroviaPK) obj;
        if (aerovia == null) {
            if (other.aerovia != null)
                return false;
        } else if (!aerovia.equals(other.aerovia))
            return false;
        if (rota == null) {
            if (other.rota != null)
                return false;
        } else if (!rota.equals(other.rota))
            return false;
        return true;
    }
}
