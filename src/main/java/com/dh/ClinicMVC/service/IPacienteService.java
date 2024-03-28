package com.dh.ClinicMVC.service;

import com.dh.ClinicMVC.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);
    List<Paciente> listarTodos();
    Optional<Paciente> buscarPorId(Long id);

    Optional<Paciente> buscarPorNombre(String nombre);
    Optional<Paciente> buscarPorApellido(String apellido);
    Optional<Paciente> buscarPorDni(String dni);








    void eliminar(Paciente paciente);
    void actualizar(Paciente paciente);
}
