package com.trabalho1.adaptadores.controllers;

import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.services.ServicoRota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rotas")
public class RotasController {
    @Autowired
    private ServicoRota servicoRota;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Rota>> findAll() {
        return new ResponseEntity<List<Rota>>(servicoRota.getRota(), HttpStatus.OK);
    }

    @GetMapping(value = "/procuraRotaEntre/{ref1}-{ref2}")
    public ResponseEntity<List<Rota>> procuraRota(@PathVariable String ref1, @PathVariable String ref2) {
        return new ResponseEntity<List<Rota>>(this.servicoRota.findRouteBetween(ref1, ref2), HttpStatus.OK);
    }
}
