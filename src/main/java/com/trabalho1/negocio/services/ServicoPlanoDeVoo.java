package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.Aerovia;
import com.trabalho1.negocio.entidades.OcupacaoAerovia;
import com.trabalho1.negocio.entidades.PlanoDeVoo;
import com.trabalho1.negocio.entidades.Rota;
import com.trabalho1.negocio.repositorios.IOcupacaoRepository;
import com.trabalho1.negocio.repositorios.IPlanoDeVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoPlanoDeVoo {


    public IPlanoDeVooRepository planoDeVooRep;
    public IOcupacaoRepository ocupacaoRep;

    @Autowired
    public ServicoPlanoDeVoo(IPlanoDeVooRepository planoDeVooRep) {
        this.planoDeVooRep = planoDeVooRep;
    }

    public List<PlanoDeVoo> getPlanoDeVoos() {
        return planoDeVooRep.findAll();
    }

    public Optional<PlanoDeVoo> getPlanoDeVoo(Integer idVoo) {
        return planoDeVooRep.findById(idVoo);
    }

    public boolean addPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        if(planoDeVooRep.existsById(planoDeVoo.getId())){
            return false;
        }
        planoDeVooRep.save(planoDeVoo);
        return true;
    }

    public boolean updatePlanoDeVoo(PlanoDeVoo planoDeVoo) {
        if(this.planoDeVooRep.existsById(planoDeVoo.getId())){
            planoDeVooRep.save(planoDeVoo);
            return true;
        }
        return false;
    }

    public boolean deletePlanoDeVoo(Integer idVoo) {
        if(planoDeVooRep.existsById(idVoo)){
            planoDeVooRep.deleteById(idVoo);
            return true;
        }
        return false;
    }


    public void saveAll(List<PlanoDeVoo> planosDeVoo) {
        planoDeVooRep.saveAll(planosDeVoo);
    }

    public PlanoDeVoo liberarPlano(int idVoo) {
        Optional<PlanoDeVoo> planoDeVoo = this.getPlanoDeVoo(idVoo);
        Rota rota = planoDeVoo.get().getRota();
        Aerovia aerovia = rota.getAerovias();
        List<Float> slotsHorarios = new ArrayList<>();

        float tempoVoo = aerovia.getDistancia() / planoDeVoo.get().getVelCruzeiro();

        for(int i=0; i<tempoVoo; i++){
            slotsHorarios.add((float) Math.floor(planoDeVoo.get().getHorarioPartida())+ i);
        }

        for(float slot: slotsHorarios){
            LocalDate date = planoDeVoo.get().getData();
            if(slot > 24){
                slot = slot - 24;
                date = date.plusDays(1);
            }
            OcupacaoAerovia ocupacaoAerovia = new OcupacaoAerovia(date, aerovia, (int)planoDeVoo.get().getAltitude(), (int)slot);
            this.updateOcupacaoAerovia(ocupacaoAerovia);
        }


        if(planoDeVoo.isPresent()){
            PlanoDeVoo plano = planoDeVoo.get();
            plano.setLiberado(true);
            this.updatePlanoDeVoo(plano);

            return plano;
        }
        return null;
    }

    private boolean updateOcupacaoAerovia(OcupacaoAerovia ocupacaoAerovia) {
        if(this.ocupacaoRep.existsById(ocupacaoAerovia.getId())){
            ocupacaoRep.save(ocupacaoAerovia);
            return true;
        }
        return false;
    }
}