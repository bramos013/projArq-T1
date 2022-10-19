package com.trabalho1.negocio.services;

import com.trabalho1.negocio.entidades.OcupacaoAerovia;
import com.trabalho1.negocio.entidades.RefGeo;
import com.trabalho1.negocio.repositorios.IAeronaveRepository;
import com.trabalho1.negocio.repositorios.IAeroviaRepository;
import com.trabalho1.negocio.repositorios.IOcupacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ServicoVerificaSlotsLivres {


    private IAeroviaRepository aeroviaRepository;
    private IAeronaveRepository aeronaveRepository;
    private IOcupacaoRepository ocupacaoRepository;

    @Autowired
    public ServicoVerificaSlotsLivres(IAeroviaRepository aeroviaRepository, IAeronaveRepository aeronaveRepository, IOcupacaoRepository ocupacaoRepository) {
        this.aeroviaRepository = aeroviaRepository;
        this.aeronaveRepository = aeronaveRepository;
        this.ocupacaoRepository = ocupacaoRepository;
    }

    public ServicoVerificaSlotsLivres() {}

    private List<RefGeo> getVia(Integer id) {
        AtomicReference<RefGeo> origem = null;
        AtomicReference<RefGeo> destino = null;

        this.aeroviaRepository.findById(id)
                .ifPresent(a -> {
                    origem.set(a.getOrigem());
                    destino.set(a.getDestino());
                });

        return List.of(origem.get(), destino.get());
    }

    private List<OcupacaoAerovia> checaSlotOcupados(Integer aeroviaId, LocalDate data, ArrayList<Float> slotsHorarios) {
        return this.ocupacaoRepository.findAll().stream()
                .filter(oa -> oa.getId() == aeroviaId)
                .filter(oa -> oa.getDate().equals(data))
                .filter(oa -> slotsHorarios.contains((float) oa.getSlotHorario()))
                .toList();
    }


    public List<Float> checaSlotsLivre(String data, Integer velCruzero, Integer horario, Integer aeroviaId, Integer quantidadeDeNiveisDeSeguranca) {
        ArrayList<Float> todosSlots = new ArrayList<>();
        ArrayList<Float> slotsHorarios = new ArrayList<>();
        this.aeroviaRepository.findById(aeroviaId)
                .ifPresent(a -> {
                    todosSlots.add(25000f);

                    long tempoDeViagem = (long) a.getDistancia() / velCruzero;
                    tempoDeViagem += horario;

                    for (int i = 1; i < quantidadeDeNiveisDeSeguranca; i++) {
                        todosSlots.add(todosSlots.get(i-1) + 1000);
                    }

                    slotsHorarios.add((float) Math.floor(horario));

                    while(tempoDeViagem > horario){
                        slotsHorarios.add((float) Math.floor(horario));
                        tempoDeViagem--;
                    }

                    slotsHorarios.add((float) Math.ceil(horario));

                    List<OcupacaoAerovia> ocupadas = this.checaSlotOcupados(aeroviaId, LocalDate.parse(data), slotsHorarios);

                    List<Integer> altitudesOcupadas = ocupadas.stream().map( ocupaAerovia -> ocupaAerovia.getNivelAlti()).toList();
                    List<Float> tipeGuard = todosSlots.stream().filter(slotsLivres -> !altitudesOcupadas.contains(slotsLivres)).toList();
                    todosSlots.clear();
                    todosSlots.addAll(tipeGuard);
                });
        return todosSlots;
    }



}
