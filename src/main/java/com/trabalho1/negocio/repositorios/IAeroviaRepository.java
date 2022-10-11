package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.Aerovia;

public interface IAeroviaRepository {
    List<Aerovia> listarTodas();
    void removeTodas();
    boolean cadastra(Aerovia aerovia);
    void removeAerovia(String nome);
    void addAerovia(Aerovia aerovia);
}
    

