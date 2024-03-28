package com.dh.ClinicMVC.service;

import com.dh.ClinicMVC.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardar (Odontologo odontologo);

    List<Odontologo> listarTodos();

    Optional<Odontologo> buscarPorId(Long id);

    Optional<Odontologo> buscarPorNombre(String nombre);
    Optional<Odontologo> buscarPorApellido(String apellido);

    Optional<Odontologo> buscarPorMatricula(String matricula);

    void actualizar(Odontologo odontologo);

    void eliminar(Odontologo odontologo);
}
