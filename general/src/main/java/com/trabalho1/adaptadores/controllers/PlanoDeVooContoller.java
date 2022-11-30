package com.trabalho1.adaptadores.controllers;

import com.trabalho1.negocio.entidades.PlanoDeVoo;
import com.trabalho1.negocio.services.ServicoPlanoDeVoo;
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
@RequestMapping("/plano_de_voo")
public class PlanoDeVooContoller {

    @Autowired
    private ServicoPlanoDeVoo servicoPlanoDeVoo;

    @GetMapping("/findAll")
    public ResponseEntity<List<PlanoDeVoo>> findAll() {
        return new ResponseEntity<List<PlanoDeVoo>>(this.servicoPlanoDeVoo.getPlanoDeVoos(), HttpStatus.OK);
    }

    @GetMapping("/findByIdVoo/{idVoo}")
    public ResponseEntity<PlanoDeVoo> findById(@PathVariable int idVoo) {
        return new ResponseEntity<PlanoDeVoo>(this.servicoPlanoDeVoo
                .getPlanoDeVoo(idVoo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "voo não enontrado")),
                HttpStatus.OK);
    }

    @GetMapping("/liberar-plano/{idVoo}")
    public ResponseEntity<PlanoDeVoo> liberarPlano(@PathVariable int idVoo) {
        try {
            return new ResponseEntity<PlanoDeVoo>(this.servicoPlanoDeVoo.liberarPlano(idVoo), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletarPlano(@PathVariable int id) {
        try {
            return new ResponseEntity<Boolean>(this.servicoPlanoDeVoo.deletePlanoDeVoo(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}