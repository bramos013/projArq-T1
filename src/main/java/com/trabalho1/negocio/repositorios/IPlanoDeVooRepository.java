package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.PlanoDeVoo;

public interface IPlanoDeVooRepository {
    void cadastra(PlanoDeVoo plano);

    void remove(String idVoo);

    void removeTodos();

    PlanoDeVoo listarPlanosDeVoo(String idVoo);

    List<PlanoDeVoo> listarTodos();
}