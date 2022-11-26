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

    @GetMapping("/liberar-plano/{idVoo}")
    public ResponseEntity<PlanoDeVoo> liberarPlano(@PathVariable int idVoo) {
        try {
            return new ResponseEntity<PlanoDeVoo>(this.servicoPlanoDeVoo.liberarPlano(idVoo), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/cancelar-plano/{id}")
    public ResponseEntity<PlanoDeVoo> cancelarPlano(@PathVariable int id) {
        try {
            return new ResponseEntity<PlanoDeVoo>(this.servicoPlanoDeVoo.cancelaPlanoDeVoo(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
