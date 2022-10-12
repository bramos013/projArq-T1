package com.trabalho1.negocio.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;

public class Rota {
    public String nome;

    // Associação - 1 plano de voo utiliza 1 rota, 1 rota pode ser utilizada por N planos de voos
    @OneToMany
    private List<PlanoDeVoo> planosDeVoo = new ArrayList<>();

    // Associação - 1 rota pode utilizar N aerovias, 1 aerovia pode ser utilizada por N rotas
    @OneToMany(mappedBy = "id.rota")
    private Set<RotaAerovia> rotasAerovias = new HashSet<>();
    
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
