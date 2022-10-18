package com.trabalho1.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.trabalho1.negocio.entidades.classes_associativas.RotaAeroviaPK;

@Entity
public class Rota implements Serializable {

    @Serial
    private static final long serialVersionUID = -632303030086059929L;

    @Id
    public String nome;

    // Associação - 1 plano de voo utiliza 1 rota, 1 rota pode ser utilizada por N planos de voos
    @OneToMany
    private List<PlanoDeVoo> planosDeVoo;

    // Associação - 1 rota pode utilizar N aerovias, 1 aerovia pode ser utilizada por N rotas
    @OneToMany
    @JoinColumn(name = "rota_id")
    private Set<RotaAerovia> rotasAerovias;
    
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

    public void addAerovia(Aerovia aerovia) {
        RotaAeroviaPK pk = new RotaAeroviaPK(this, aerovia);
        RotaAerovia rotaAerovia = new RotaAerovia(pk);
        rotasAerovias.add(rotaAerovia);
    }

    @Override
    public String toString() {
        return "Rota [nome=" + nome + "]";
    }

}
