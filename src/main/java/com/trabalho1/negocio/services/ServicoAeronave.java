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

    public void cadastra(Aeronave aeronave) {
        aeronaveRep.removeTodas();
        aeronaveRep.cadastra(aeronave);
    }

    public void remove(String prefixo) {
        aeronaveRep.remove(prefixo);
    }

    public void removeTodas() {
        aeronaveRep.removeTodas();
    }

    public Aeronave listarAeronave(String prefixo) {
        return aeronaveRep.listarAeronave(prefixo);
    }

    public List<Aeronave> listarTodas() {
        return aeronaveRep.listarTodas();
    }

}
