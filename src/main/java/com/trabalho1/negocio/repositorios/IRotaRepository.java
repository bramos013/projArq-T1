package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.Rota;

public interface IRotaRepository {
    void cadastra(Rota rota);

    void remove(String nome);

    void removeTodas();

    Rota listarRotas(String nome);

    List<Rota> listarTodas();
}