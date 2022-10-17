package com.trabalho1.negocio.services;

import java.util.List;

import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.repositorios.IRefGeoRepository;

public class ServicoRefGeo {

    public IRefGeoRepository refGeoRep;

    public ServicoRefGeo(IRefGeoRepository refGeoRep) {
        this.refGeoRep = refGeoRep;
    }

    public List<RefGeo> getRefGeo() {
        return refGeoRep.findAll();
    }

    public RefGeo getRefGeoById(String id) {
        return refGeoRep.findById(id).get();
    }

    public boolean addRefGeo(RefGeo refGeo) {
        if(refGeoRep.existsById(refGeo.getNome())){
            return false;
        }
        refGeoRep.save(refGeo);
        return true;
    }

    public boolean updateRefGeo(RefGeo refGeo) {
        if(refGeoRep.existsById(refGeo.getNome())){
            refGeoRep.save(refGeo);
            return true;
        }
        return false;
    }

    public boolean deleteRefGeo(String nome) {
        if(refGeoRep.existsById(nome)){
            refGeoRep.deleteById(nome);
            return true;
        }
        return false;
    }
   
    public void saveAll(List<RefGeo> refGeo) {
        refGeoRep.saveAll(refGeo);
    }
}
