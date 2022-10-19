package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.PlanoDeVoo;
import com.trabalho1.negocio.repositorios.IPlanoDeVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPlanoDeVoo {


    public IPlanoDeVooRepository planoDeVooRep;

    @Autowired
    public ServicoPlanoDeVoo(IPlanoDeVooRepository planoDeVooRep) {
        this.planoDeVooRep = planoDeVooRep;
    }

    public List<PlanoDeVoo> getPlanoDeVoos() {
        return planoDeVooRep.findAll();
    }

    public Optional<PlanoDeVoo> getPlanoDeVoo(Integer idVoo) {
        return planoDeVooRep.findById(idVoo);
    }

    public boolean addPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        if(planoDeVooRep.existsById(planoDeVoo.getId())){
            return false;
        }
        planoDeVooRep.save(planoDeVoo);
        return true;
    }

    public boolean updatePlanoDeVoo(PlanoDeVoo planoDeVoo) {
        if(this.planoDeVooRep.existsById(planoDeVoo.getId())){
            planoDeVooRep.save(planoDeVoo);
            return true;
        }
        return false;
    }

    public boolean deletePlanoDeVoo(Integer idVoo) {
        if(planoDeVooRep.existsById(idVoo)){
            planoDeVooRep.deleteById(idVoo);
            return true;
        }
        return false;
    }

    public void saveAll(List<PlanoDeVoo> planosDeVoo) {
        planoDeVooRep.saveAll(planosDeVoo);
    }

    public boolean aprovaPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        
        return false;
    }
}