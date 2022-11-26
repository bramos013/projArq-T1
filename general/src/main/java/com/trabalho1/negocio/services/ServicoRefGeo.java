package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.repositorios.IRefGeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoRefGeo {

    public IRefGeoRepository refGeoRep;

    @Autowired
    public ServicoRefGeo(IRefGeoRepository refGeoRep) {
        this.refGeoRep = refGeoRep;
    }

    public List<RefGeo> getRefGeo() {
        return refGeoRep.findAll();
    }

    public RefGeo getRefGeoById(Integer id) {
        return refGeoRep.findById(id).get();
    }

    public boolean addRefGeo(RefGeo refGeo) {
        if(refGeoRep.existsById(refGeo.getId())){
            return false;
        }
        refGeoRep.save(refGeo);
        return true;
    }

    public boolean updateRefGeo(RefGeo refGeo) {
        if(refGeoRep.existsById(refGeo.getId())){
            refGeoRep.save(refGeo);
            return true;
        }
        return false;
    }

    public boolean deleteRefGeo(Integer id) {
        if(refGeoRep.existsById(id)){
            refGeoRep.deleteById(id);
            return true;
        }
        return false;
    }
   
    public void saveAll(List<RefGeo> refGeo) {
        refGeoRep.saveAll(refGeo);
    }
}
