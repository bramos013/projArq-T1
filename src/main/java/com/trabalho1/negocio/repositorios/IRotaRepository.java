package com.trabalho1.negocio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho1.negocio.entidades.Rota;
import org.springframework.stereotype.Repository;

@Repository
public interface IRotaRepository extends JpaRepository<Rota, String> {

}