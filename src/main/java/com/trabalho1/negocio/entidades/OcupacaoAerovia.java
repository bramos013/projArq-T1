package com.trabalho1.negocio.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "ocupacoes_Aerovias")
public class OcupacaoAerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;

    @OneToMany
    @JoinColumn(name = "aerovia_id")
    private Set<Aerovia> aerovias;

    private int nivelAlti;
    private int horario;

    public OcupacaoAerovia(){

    }

    public OcupacaoAerovia(int id, LocalDate date, Set<Aerovia> aerovia, int nivelAlti, int horario) {
        this.id = id;
        this.data = date;
        this.aerovias = aerovia;
        this.nivelAlti = nivelAlti;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return data;
    }

    public void setDate(LocalDate date) {
        this.data = date;
    }



    public int getNivelAlti() {
        return nivelAlti;
    }

    public void setNivelAlti(int nivelAlti) {
        this.nivelAlti = nivelAlti;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
}