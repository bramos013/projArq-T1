package com.trabalho1.negocio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho1.negocio.entidades.Aerovia;

public interface IAeroviaRepository extends JpaRepository<Aerovia, String> {


}
