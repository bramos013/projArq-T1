package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.RotaAerovia;
import com.trabalho1.negocio.repositorios.IRotaAeroviaRepository;

@Component
public class ServicoRotaAerovia {
    public IRotaAeroviaRepository rotaAeroviaRep;

    public ServicoRotaAerovia(IRotaAeroviaRepository rotaAeroviaRep) {
        this.rotaAeroviaRep = rotaAeroviaRep;
    }

    public List<RotaAerovia> getRotaAerovias() {
        return rotaAeroviaRep.findAll();
    }

    public boolean addRotaAerovia(RotaAerovia rotaAerovia) {
        rotaAeroviaRep.save(rotaAerovia);
        return true;
    }

    public boolean updateRotaAerovia(RotaAerovia rotaAerovia) {
        rotaAeroviaRep.save(rotaAerovia);
        return true;
    }

    public boolean deleteRotaAerovia(String prefixo) {
        rotaAeroviaRep.deleteById(prefixo);
        return true;
    }

    public void saveAll(List<RotaAerovia> rotasAerovias) {
        rotaAeroviaRep.saveAll(rotasAerovias);
    }

}
