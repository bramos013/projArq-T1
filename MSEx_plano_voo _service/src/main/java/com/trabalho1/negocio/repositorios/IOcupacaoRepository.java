package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.OcupacaoAerovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IOcupacaoRepository extends JpaRepository<OcupacaoAerovia, Integer> {

}
