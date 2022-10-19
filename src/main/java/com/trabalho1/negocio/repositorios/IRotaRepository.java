package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRotaRepository extends JpaRepository<Rota, Integer> {

}