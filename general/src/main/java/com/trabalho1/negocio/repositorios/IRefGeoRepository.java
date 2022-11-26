package com.trabalho1.negocio.repositorios;

import com.trabalho1.negocio.entidades.RefGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefGeoRepository extends JpaRepository<RefGeo, Integer> {

}
