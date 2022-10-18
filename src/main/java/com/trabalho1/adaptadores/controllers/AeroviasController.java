package com.trabalho1.adaptadores.controllers;

import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.services.ServicoAerovia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/aerovias")
public class AeroviasController {

    @Autowired
    private ServicoAerovia servicoAerovia;

    @GetMapping("/findAll")
    public ResponseEntity<List<Aerovia>> findAll() {
        return new ResponseEntity<List<Aerovia>>(this.servicoAerovia.getAerovias(), HttpStatus.OK);
    }
}
