package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.repositorios.IAeroviaRepository;


@Component
public class ServicoAerovia {
    public IAeroviaRepository aeroviaRep;

    public ServicoAerovia(IAeroviaRepository aeroviaRep){
        this.aeroviaRep = aeroviaRep;
    }

    public List<Aerovia> getAerovias() {
        return aeroviaRep.findAll();
    }

    public Aerovia getAerovia(String nome) {
        return aeroviaRep.findById(nome).get();
    }

    public boolean addAerovia(Aerovia aerovia) {
        if(aeroviaRep.existsById(aerovia.getNome())){
            return false;
        }
        aeroviaRep.save(aerovia);
        return true;
    }

    public boolean updateAerovia(Aerovia aerovia) {
        if(aeroviaRep.existsById(aerovia.getNome())){
            aeroviaRep.save(aerovia);
            return true;
        }
        return false;
    }

    public boolean deleteAerovia(String nome) {
        if(aeroviaRep.existsById(nome)){
            aeroviaRep.deleteById(nome);
            return true;
        }
        return false;
    }

    public void saveAll(List<Aerovia> aerovias) {
        aeroviaRep.saveAll(aerovias);
    }

}