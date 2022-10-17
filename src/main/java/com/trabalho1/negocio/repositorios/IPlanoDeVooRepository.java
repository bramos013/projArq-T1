package com.trabalho1.negocio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho1.negocio.entidades.PlanoDeVoo;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanoDeVooRepository extends JpaRepository<PlanoDeVoo, String> {

}