package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.Aeronave;

public interface IAeronaveRepository {
    void cadastra(Aeronave aeronave);

    void remove(String nome);

    void removeTodas();

    Aeronave listarAeronave(String prefixo);

    List<Aeronave> listarTodas();

}
