package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;

@Component
public class ServicoAeronave {
    public IAeronaveRepository aeronaveRep;

    public ServicoAeronave(IAeronaveRepository aeronaveRep) {
        this.aeronaveRep = aeronaveRep;
    }

    public List<Aeronave> getAeronaves() {
        return aeronaveRep.findAll();
    }

    public Aeronave getAeronave(String prefixo) {
        return aeronaveRep.findById(prefixo).get();
    }

    public boolean addAeronave(Aeronave aeronave) {
        if(aeronaveRep.existsById(aeronave.getPrefixo())){
            return false;
        }
        aeronaveRep.save(aeronave);
        return true;
    }

    public boolean updateAeronave(Aeronave aeronave) {
        if(aeronaveRep.existsById(aeronave.getPrefixo())){
            aeronaveRep.save(aeronave);
            return true;
        }
        return false;
    }

    public boolean deleteAeronave(String prefixo) {
        if(aeronaveRep.existsById(prefixo)){
            aeronaveRep.deleteById(prefixo);
            return true;
        }
        return false;
    }

    public void saveAll(List<Aeronave> aeronaves) {
        aeronaveRep.saveAll(aeronaves);
    }

}
