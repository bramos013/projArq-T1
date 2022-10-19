package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.repositorios.IAeroviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicoAerovia {

    public IAeroviaRepository aeroviaRep;

    @Autowired
    public ServicoAerovia(IAeroviaRepository aeroviaRep){
        this.aeroviaRep = aeroviaRep;
    }

    public List<Aerovia> getAerovias() {
        return aeroviaRep.findAll();
    }

    public Aerovia getAerovia(Integer id) {
        return aeroviaRep.findById(id).get();
    }

    public boolean addAerovia(Aerovia aerovia) {
        if(aeroviaRep.existsById(aerovia.getId())){
            return false;
        }
        aeroviaRep.save(aerovia);
        return true;
    }

    public boolean updateAerovia(Aerovia aerovia) {
        if(aeroviaRep.existsById(aerovia.getId())){
            aeroviaRep.save(aerovia);
            return true;
        }
        return false;
    }

    public boolean deleteAerovia(Integer id) {
        if(aeroviaRep.existsById(id)){
            aeroviaRep.deleteById(id);
            return true;
        }
        return false;
    }

    public void saveAll(List<Aerovia> aerovias) {
        aeroviaRep.saveAll(aerovias);
    }

}