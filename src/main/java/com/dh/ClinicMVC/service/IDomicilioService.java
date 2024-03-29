package com.dh.ClinicMVC.service;

import com.dh.ClinicMVC.entity.Domicilio;
import com.dh.ClinicMVC.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {
    Domicilio guardar (Domicilio domicilio);

    Optional<Domicilio> buscarPorId(Long id);
    Optional<Domicilio> buscarPorCalle(String calle);

    Optional<Domicilio> buscarPorNumero(Integer numero);

    Optional<Domicilio> buscarPorLocalidad(String localidad);

    Optional<Domicilio> buscarPorProvincia(String provincia);

    void actualizar(Domicilio domicilio);

    void eliminar(Domicilio domicilio);
}
