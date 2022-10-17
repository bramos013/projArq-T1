package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.PlanoDeVoo;
import com.trabalho1.negocio.repositorios.IPlanoDeVooRepository;

@Component
public class ServicoPlanoDeVoo {
    public IPlanoDeVooRepository planoDeVooRep;

    public ServicoPlanoDeVoo(IPlanoDeVooRepository planoDeVooRep) {
        this.planoDeVooRep = planoDeVooRep;
    }

    public List<PlanoDeVoo> getPlanoDeVoos() {
        return planoDeVooRep.findAll();
    }

    public PlanoDeVoo getPlanoDeVoo(String idVoo) {
        return planoDeVooRep.findById(idVoo).get();
    }

    public boolean addPlanoDeVoo(PlanoDeVoo PlanoDeVoo) {
        if(planoDeVooRep.existsById(PlanoDeVoo.getIdVoo())){
            return false;
        }
        planoDeVooRep.save(PlanoDeVoo);
        return true;
    }

    public boolean updatePlanoDeVoo(PlanoDeVoo PlanoDeVoo) {
        if(planoDeVooRep.existsById(PlanoDeVoo.getIdVoo())){
            planoDeVooRep.save(PlanoDeVoo);
            return true;
        }
        return false;
    }

    public boolean deletePlanoDeVoo(String idVoo) {
        if(planoDeVooRep.existsById(idVoo)){
            planoDeVooRep.deleteById(idVoo);
            return true;
        }
        return false;
    }

    public void saveAll(List<PlanoDeVoo> planosDeVoo) {
        planoDeVooRep.saveAll(planosDeVoo);
    }
}