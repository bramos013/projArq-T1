package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.OcupacaoAerovia;
import com.trabalho1.negocio.repositorios.IOcupacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoOcupacao {
    private IOcupacaoRepository repository;

    @Autowired
    public ServicoOcupacao(IOcupacaoRepository repository){
        this.repository = repository;
    }

    public ServicoOcupacao() {

    }


    public void save(OcupacaoAerovia ocupacaoAerovia) {
        this.repository.save(ocupacaoAerovia);
    }


}
