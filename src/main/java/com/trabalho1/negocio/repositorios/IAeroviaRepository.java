package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.Aerovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAeroviaRepository extends JpaRepository<Aerovia, Integer> {


}
