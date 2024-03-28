package com.dh.ClinicMVC.repository;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.nombre = ?1")
    Optional<Paciente> buscarPacientePorNombre(String nombre);

    @Query("SELECT p FROM Paciente p WHERE p.apellido = ?1")
    Optional<Paciente> buscarPacientePorApellido(String apellido);

    @Query("SELECT p FROM Paciente p WHERE p.dni = ?1")
    Optional<Paciente> buscarPacientePorDni(String dni);

    @Query("SELECT p FROM Paciente p WHERE p.fechaIngreso = ?1")
    Optional<Paciente> buscarPacientePorFechaIngreso(LocalDate fecha);
}