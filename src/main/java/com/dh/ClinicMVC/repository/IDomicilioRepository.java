package com.dh.ClinicMVC.repository;


import com.dh.ClinicMVC.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {
    @Query("SELECT d FROM Domicilio d WHERE d.calle = ?1")
    Optional<Domicilio> buscarPorCalle(String calle);

    @Query("SELECT d FROM Domicilio d WHERE d.numero = ?1")
    Optional<Domicilio> buscarPorNumero(Integer numero);

    @Query("SELECT d FROM Domicilio d WHERE d.localidad = ?1")
    Optional<Domicilio> buscarPorLocalidad(String localidad);

    @Query("SELECT d FROM Domicilio d WHERE d.provincia = ?1")
    Optional<Domicilio> buscarPorProvincia(String provincia);

}
