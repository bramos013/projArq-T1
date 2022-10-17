package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.Aeronave;

public interface IAeronaveRepository {
    boolean cadastra(Aeronave aeronave);

    boolean remove(String nome);

    boolean removeTodas();

    Aeronave listarAeronave(String prefixo);

    // List<Aeronave> listarTodas();

}
