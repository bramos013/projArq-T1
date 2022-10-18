package com.trabalho1.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.trabalho1.negocio.entidades.classes_associativas.RotaAeroviaPK;

@Entity
@Table(name = "aerovias")
public class Aerovia implements Serializable {
    @Serial
    private static final long serialVersionUID = 1666440451480265571L;

    @Id
    private String nome;
    @OneToOne // verificar relação
    @JoinColumn(name = "origem")
    private RefGeo origem;
    @OneToOne
    @JoinColumn(name = "destino")
    private RefGeo destino;
    private float distancia;

    // Associação - rota pode utilizar 1 aerovia, 1 aerovia pode ser utilizada por N rotas
    @OneToMany
    @JoinColumn(name = "aerovia_id")
    private Set<RotaAerovia> rotasAerovias;

    public Aerovia(String nome, RefGeo origem, RefGeo destino, float distancia) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Aerovia() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RefGeo getOrigem() {
        return origem;
    }

    public void setOrigem(RefGeo origem) {
        this.origem = origem;
    }

    public RefGeo getDestino() {
        return destino;
    }

    public void setDestino(RefGeo destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void addRota(Rota rota) {
        RotaAeroviaPK pk = new RotaAeroviaPK(rota, this);
        RotaAerovia rotaAerovia = new RotaAerovia(pk);
        rotasAerovias.add(rotaAerovia);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + Float.floatToIntBits(distancia);
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
        Aerovia other = (Aerovia) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (Float.floatToIntBits(distancia) != Float.floatToIntBits(other.distancia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aerovia [nome=" + nome + ", origem=" + origem + ", destino=" + destino + ", distancia=" + distancia
                + "]";
    }
}