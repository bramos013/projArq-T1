package com.trabalho1.adaptadores.controllers;

import com.trabalho1.negocio.repositorios.IAeroviaRepository;
import com.trabalho1.negocio.repositorios.IOcupacaoRepository;
import com.trabalho1.negocio.services.ServicoOcupacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ocupacao")
public class OcupacaoController {
    @Autowired
    ServicoOcupacao servicoOcupacao;

    @GetMapping("/slotsLivres/{data},{velCruzeiro},{horario},{aeroviaId}")
    public ResponseEntity<List<Float>> slotsLivres(
            @PathVariable String data,
            @PathVariable Integer velCruzeiro,
            @PathVariable Integer horario,
            @PathVariable Integer aeroviaId
    ) {
        return new ResponseEntity<List<Float>>(servicoOcupacao.slotsLivre(
                data, velCruzeiro, horario, aeroviaId, 10
        ), HttpStatus.OK);
    }
}
