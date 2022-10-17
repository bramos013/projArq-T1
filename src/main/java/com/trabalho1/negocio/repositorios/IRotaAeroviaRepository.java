package com.trabalho1.negocio.repositorios;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho1.negocio.entidades.RotaAerovia;
import org.springframework.stereotype.Repository;

@Repository
public interface IRotaAeroviaRepository extends JpaRepository<RotaAerovia, String> {


}
