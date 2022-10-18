package com.trabalho1.adaptadores.controllers;

import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.services.ServicoRota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/rotas")
public class RotasController {
    @Autowired
    private ServicoRota servicoRota;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Rota>> findAll() {
        System.out.println("this is call");
        return new ResponseEntity<List<Rota>>(servicoRota.getRota(), HttpStatus.OK);
    }
}
