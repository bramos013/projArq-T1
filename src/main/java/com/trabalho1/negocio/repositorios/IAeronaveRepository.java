package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.Aeronave;

public interface IAeronaveRepository {
    List<Aeronave> listarTodas();
    void removeTodas();
    boolean cadastra(Aeronave aeronave);
    void removeAeronave(String nome);
    void addAeronave(Aeronave aeronave);
}
    

