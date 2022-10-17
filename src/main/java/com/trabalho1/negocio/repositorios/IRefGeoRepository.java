package com.trabalho1.negocio.repositorios;

import java.util.List;
import com.trabalho1.negocio.entidades.RefGeo;

public interface IRefGeoRepository {
    boolean cadastra(RefGeo refGeo);

    boolean remove(String nome);

    boolean removeTodas();

    RefGeo listarRefGeo(String nome);

    //List<RefGeo> listarTodas();
}
