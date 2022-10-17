package com.trabalho1.negocio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho1.negocio.entidades.Aeronave;
import org.springframework.stereotype.Repository;

@Repository
public interface IAeronaveRepository extends JpaRepository<Aeronave, String> {

}
