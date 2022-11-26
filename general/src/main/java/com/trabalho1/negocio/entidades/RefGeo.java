package com.trabalho1.negocio.entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "refs_geos")
public class RefGeo implements Serializable {

        @Serial
        private static final long serialVersionUID = -7846769630819534737L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nome;
        private Double latitude;
        private Double longitude;

        public RefGeo(String nome, Double latitude, Double longitude) {
                this.nome = nome;
                this.latitude = latitude;
                this.longitude = longitude;
        }

        public RefGeo() {

        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public Double getLatitude() {
                return latitude;
        }

        public void setLatitude(Double latitude) {
                this.latitude = latitude;
        }

        public Double getLongitude() {
                return longitude;
        }

        public void setLongitude(Double longitude) {
                this.longitude = longitude;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
                RefGeo other = (RefGeo) obj;
                if (nome == null) {
                        if (other.nome != null)
                                return false;
                } else if (!nome.equals(other.nome))
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "RefGeo [nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude + "]";
        }
}