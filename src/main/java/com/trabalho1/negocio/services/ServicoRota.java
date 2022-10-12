package com.trabalho1.negocio.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.repositorios.IRotaRepository;

@Component
public class ServicoRota {
    public IRotaRepository rotaRep;

    public ServicoRota(IRotaRepository rotaRep) {
        this.rotaRep = rotaRep;
    }

    public void cadastra(Rota rota) {
        rotaRep.removeTodas();
        rotaRep.cadastra(rota);
    }

    public void remove(String nome) {
        rotaRep.remove(nome);
    }

    public void removeTodos() {
        rotaRep.removeTodas();
    }

    public Rota listarRotas(String nome) {
        return rotaRep.listarRotas(nome);
    }

    public List<Rota> listarTodas() {
        return rotaRep.listarTodas();
    }
}