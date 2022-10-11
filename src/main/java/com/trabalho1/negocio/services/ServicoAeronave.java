package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;

@Component
public class ServicoAeronave {
    public IAeronaveRepository aeronaveRep;

    public ServicoAeronave(IAeronaveRepository aeronaveRep){
        this.aeronaveRep = aeronaveRep;
    }

    public void cadastraAeronave(Aeronave aeronave){
        aeronaveRep.removeTodas();
        aeronaveRep.cadastra(aeronave);
    }

    public List<Aeronave> listarTodas(){
        return aeronaveRep.listarTodas();
    }

    public void removeTodas(){
        aeronaveRep.removeTodas();
}

public Aeronave removeAeronave(){
        aeronaveRep.removeAeronave();
}

}
