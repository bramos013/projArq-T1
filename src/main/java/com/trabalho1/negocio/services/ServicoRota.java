package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.repositorios.IRotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Rota getRotaById(Integer id) {
        return rotaRep.findById(id).get();
    }

    public boolean addRota(Rota Rota) {
        if(rotaRep.existsById(Rota.getId())){
            return false;
        }
        rotaRep.save(Rota);
        return true;
    }

    public boolean updateRota(Rota Rota) {
        if(rotaRep.existsById(Rota.getId())){
            rotaRep.save(Rota);
            return true;
        }
        return false;
    }

    public boolean deleteRota(Integer id) {
        if(rotaRep.existsById(id)){
            rotaRep.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Rota> findRouteBetween(String nomeOrigem, String nomeDestino) {
       return this.rotaRep.findAll().stream().filter(rota -> {
           boolean t1 = rota.getAerovias().getOrigem().getNome().equals(nomeOrigem);
           boolean t2 = rota.getAerovias().getDestino().getNome().equals(nomeDestino);
           return t1 && t2;
       }).toList();
    }
    public void saveAll(List<Rota> rotas) {
        rotaRep.saveAll(rotas);
    }
}