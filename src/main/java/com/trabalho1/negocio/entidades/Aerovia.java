package com.trabalho1.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aerovia {
    @Id
    private String nome;
    private RefGeo origem;
    private RefGeo destino;
    private float distancia;

    public Aerovia(String nome, RefGeo origem, RefGeo destino, float distancia) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
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