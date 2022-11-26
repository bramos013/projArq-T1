package com.trabalho1.negocio.entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rotas")
public class Rota implements Serializable {

    @Serial
    private static final long serialVersionUID = -632303030086059929L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany
    @JoinColumn(name = "plano_de_voo_id")
    private Set<PlanoDeVoo> planosDeVoo;

    @ManyToOne
    @JoinColumn(name = "aerovia_id")
    private Aerovia aerovias;
    
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<PlanoDeVoo> getPlanosDeVoo() {
        return planosDeVoo;
    }

    public void setPlanosDeVoo(Set<PlanoDeVoo> planosDeVoo) {
        this.planosDeVoo = planosDeVoo;
    }

    public Aerovia getAerovias() {
        return aerovias;
    }

    public void setAerovias(Aerovia aerovias) {
        this.aerovias = aerovias;
    }

    @Override
    public String toString() {
        return "Rota [nome=" + nome + "]";
    }

}
