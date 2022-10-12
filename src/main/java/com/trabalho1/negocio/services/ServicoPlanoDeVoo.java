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

    public void cadastra(PlanoDeVoo planoDeVoo) {
        planoDeVooRep.removeTodos();
        planoDeVooRep.cadastra(planoDeVoo);
    }

    public void remove(String idVoo) {
        planoDeVooRep.remove(idVoo);
    }

    public void removeTodos() {
        planoDeVooRep.removeTodos();
    }

    public PlanoDeVoo listarPlanosDeVoo(String idVoo) {
        return planoDeVooRep.listarPlanosDeVoo(idVoo);
    }

    public List<PlanoDeVoo> listarTodos() {
        return planoDeVooRep.listarTodos();
    }
}