package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.repositorios.IRotaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoRota {
    public IRotaRepository rotaRep;

    @Autowired
    public ServicoRota(IRotaRepository rotaRep) {
        this.rotaRep = rotaRep;
    }

    public List<Rota> getRota() {
        return rotaRep.findAll();
    }

    public Rota getRotaById(String id) {
        return rotaRep.findById(id).get();
    }

    public boolean addRota(Rota Rota) {
        if(rotaRep.existsById(Rota.getNome())){
            return false;
        }
        rotaRep.save(Rota);
        return true;
    }

    public boolean updateRota(Rota Rota) {
        if(rotaRep.existsById(Rota.getNome())){
            rotaRep.save(Rota);
            return true;
        }
        return false;
    }

    public boolean deleteRota(String nome) {
        if(rotaRep.existsById(nome)){
            rotaRep.deleteById(nome);
            return true;
        }
        return false;
    }

    public List<Rota> findAll() {
        return this.rotaRep.findAll();
    }
    
    public void saveAll(List<Rota> rotas) {
        rotaRep.saveAll(rotas);
    }
}