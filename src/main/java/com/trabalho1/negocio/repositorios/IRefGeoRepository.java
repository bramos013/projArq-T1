package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.RefGeo;

public interface IRefGeoRepository {
    void cadastra(RefGeo refGeo);

    void remove(String nome);

    void removeTodas();

    RefGeo listarRefGeo(String nome);

    List<RefGeo> listarTodas();
}
