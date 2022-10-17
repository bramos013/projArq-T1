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

    public void cadastraAeronave(Aerovia aerovia){
        aeroviaRep.removeTodas();
        aeroviaRep.cadastra(aerovia);
    }

    // public List<Aerovia> listarTodas(){
    //     return aeroviaRep.listarTodas();
    // }

    public void removeTodas(){
        aeroviaRep.removeTodas();
    }

}