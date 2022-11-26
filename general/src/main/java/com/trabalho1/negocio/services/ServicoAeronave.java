package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoAeronave {

    public IAeronaveRepository aeronaveRep;

    @Autowired
    public ServicoAeronave(IAeronaveRepository aeronaveRep) {
        this.aeronaveRep = aeronaveRep;
    }

    public List<Aeronave> getAeronaves() {
        return aeronaveRep.findAll();
    }

    public Optional<Aeronave> getAeronave(Integer id) {
        return aeronaveRep.findById(id);
    }

    public boolean addAeronave(Aeronave aeronave) {
        if(aeronaveRep.existsById(aeronave.getId())){
            return false;
        }
        aeronaveRep.save(aeronave);
        return true;
    }

    public boolean updateAeronave(Aeronave aeronave) {
        if(aeronaveRep.existsById(aeronave.getId())){
            aeronaveRep.save(aeronave);
            return true;
        }
        return false;
    }

    public boolean deleteAeronave(Integer id) {
        if(aeronaveRep.existsById(id)){
            aeronaveRep.deleteById(id);
            return true;
        }
        return false;
    }

    public void saveAll(List<Aeronave> aeronaves) {


    }

}
