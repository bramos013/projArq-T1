package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.Aerovia;

public interface IAeroviaRepository {
    void cadastra(Aerovia aerovia);

    void remove(String nome);

    void removeTodas();

    Aerovia listarAerovia(String nome);

    //List<Aerovia> listarTodas();

}
