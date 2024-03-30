package com.dh.ClinicMVC.repository;

import com.dh.ClinicMVC.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo o WHERE o.nombre = ?1")
    Optional<Odontologo> buscarOdontologoPorNombre(String nombre);

    @Query("SELECT o FROM Odontologo o WHERE o.apellido = ?1")
    Optional<Odontologo> buscarOdontologoPorApellido(String apellido);

    @Query("SELECT o FROM Odontologo o WHERE o.matricula = ?1")
    Optional<Odontologo> buscarOdontologoPorMatriucula(String matricula);
}