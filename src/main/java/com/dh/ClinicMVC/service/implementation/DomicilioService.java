package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.entity.Domicilio;
import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.entity.Paciente;
import com.dh.ClinicMVC.repository.IDomicilioRepository;
import com.dh.ClinicMVC.repository.IOdontologoRepository;
import com.dh.ClinicMVC.service.IDomicilioService;
import com.dh.ClinicMVC.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService {
    private IDomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(IDomicilioRepository domicilioRepository){this.domicilioRepository = domicilioRepository;}

    @Override
    public Domicilio guardar(Domicilio domicilio){return domicilioRepository.save(domicilio);}

    @Override
    public Optional<Domicilio> buscarPorId(Long id) {
        Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
        if(domicilioOptional.isPresent()){
            return domicilioOptional;
        }
        return null;
    }

    @Override
    public Optional<Domicilio> buscarPorCalle(String calle) {
        Optional<Domicilio> domicilioOptional = domicilioRepository.buscarPorCalle(calle);
        if(domicilioOptional.isPresent()){
            return domicilioOptional;
        }
        return null;
    }

    @Override
    public Optional<Domicilio> buscarPorNumero(Integer numero) {
        Optional<Domicilio> domicilioOptional = domicilioRepository.buscarPorNumero(numero);
        if(domicilioOptional.isPresent()){
            return domicilioOptional;
        }
        return null;
    }

    @Override
    public Optional<Domicilio> buscarPorLocalidad(String localidad) {
        Optional<Domicilio> domicilioOptional = domicilioRepository.buscarPorLocalidad(localidad);
        if(domicilioOptional.isPresent()){
            return domicilioOptional;
        }
        return null;
    }

    @Override
    public Optional<Domicilio> buscarPorProvincia(String provincia) {
        Optional<Domicilio> domicilioOptional = domicilioRepository.buscarPorProvincia(provincia);
        if(domicilioOptional.isPresent()){
            return domicilioOptional;
        }
        return null;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Domicilio domicilio) {
        domicilioRepository.delete(domicilio);
    }
}