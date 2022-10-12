package com.trabalho1.negocio.services;

import java.util.List;

import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.repositorios.IRefGeoRepository;

public class ServicoRefGeo {

    public IRefGeoRepository refGeoRep;

    public ServicoRefGeo(IRefGeoRepository refGeoRep) {
        this.refGeoRep = refGeoRep;
    }

    public void cadastra(RefGeo refGeo) {
        refGeoRep.cadastra(refGeo);
    }

    public void remove(String nome) {
        refGeoRep.remove(nome);
    }

    public void removeTodas() {
        refGeoRep.removeTodas();
    }

    public RefGeo listarRefGeo(String nome) {
        return refGeoRep.listarRefGeo(nome);
    }

    public List<RefGeo> listarTodas() {
        return refGeoRep.listarTodas();
    }
}
