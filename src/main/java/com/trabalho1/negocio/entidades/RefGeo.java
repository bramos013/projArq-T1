package com.trabalho1.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RefGeo {
        @Id
        private String nome;
        private float latitude;
        private float longitude;

        public void Aerovia(String nome, float latitude, float longitude) {
                this.nome = nome;
                this.latitude = latitude;
                this.longitude = longitude;
                
    }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public float getLatitude() {
                return latitude;
        }

        public void setLatitude(float latitude) {
                this.latitude = latitude;
        }

        public float getLongitude() {
                return longitude;
        }

        public void setLongitude(float longitude) {
                this.longitude = longitude;
        }

        @Override
        public String toString() {
                return "RefGeo [nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude + "]";
        }
}