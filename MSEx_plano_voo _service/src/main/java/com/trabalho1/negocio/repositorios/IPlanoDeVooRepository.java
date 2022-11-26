package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.PlanoDeVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanoDeVooRepository extends JpaRepository<PlanoDeVoo, Integer> {

}