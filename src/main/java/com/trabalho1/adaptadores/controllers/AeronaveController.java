package com.trabalho1.adaptadores.controllers;

import com.trabalho1.adaptadores.repositorios.AeronaveRepository;
import com.trabalho1.negocio.entidades.Aeronave;
import com.trabalho1.negocio.services.ServicoAeronave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/aeronaves")
public class AeronaveController {
    @Autowired
    private ServicoAeronave repository;

    @GetMapping("/findAll")
    public ResponseEntity<List<Aeronave>> findAll(){
        return new ResponseEntity<List<Aeronave>>(repository.getAeronaves(), HttpStatus.OK);
    }

    @GetMapping("/findByPrefix/{prefix}")
    public ResponseEntity<Aeronave> findById(@PathVariable String prefix) {
        return new ResponseEntity<Aeronave>(this.repository.getAeronave(prefix)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                , HttpStatus.OK);
    }
}
