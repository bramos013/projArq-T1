package com.trabalho1.negocio.entidades;

public class Rota {
    public String nome;

    public Rota() {
    }

    public Rota(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Rota [nome=" + nome + "]";
    }

}
