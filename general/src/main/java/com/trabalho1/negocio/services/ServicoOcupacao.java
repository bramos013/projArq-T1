package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.OcupacaoAerovia;
import com.trabalho1.negocio.repositorios.IOcupacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoOcupacao {
    private IOcupacaoRepository repository;
    private ServicoVerificaSlotsLivres slots;

    @Autowired
    public ServicoOcupacao(IOcupacaoRepository repository, ServicoVerificaSlotsLivres slots) {
        this.repository = repository;
        this.slots = slots;
    }

    public ServicoOcupacao() {

    }

    public List<Float> slotsLivre(String data, Integer velCruzero, Integer horario, Integer aeroviaId, Integer quantidadeDeNiveisDeSeguranca) {
        return this.slots.checaSlotsLivre(data, velCruzero, horario, aeroviaId, quantidadeDeNiveisDeSeguranca);
    }

    public void save(OcupacaoAerovia ocupacaoAerovia) {
        this.repository.save(ocupacaoAerovia);
    }


}
