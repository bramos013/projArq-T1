package com.trabalho1.adaptadores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController


@RequestMapping(value = "/")
public class Routes {

    @RequestMapping("/consultarRota")
    public String consultarRota() {
        return "consultarRota";
    }

    @RequestMapping("/consultarSlots")
    public String consultarSlots() {
        return "consultarSlots";
    }

    @RequestMapping("/verificarPlanoVoo")
    public String verificarPlanoVoo() {
        return "verificarPlanoVoo";
    }

    @RequestMapping("/liberarPlanoVoo")
    public String liberarPlanoVoo() {
        return "liberarPlanoVoo";
    }

    @RequestMapping("/cancelarPlanoVoo")
    public String cancelarPlanoVoo() {
        return "cancelarPlanoVoo";
    }

    @RequestMapping("/gerarRelatorioOcupacao")
    public String gerarRelatorioOcupacao() {
        return "gerarRelatorioOcupacao";
    }
}
