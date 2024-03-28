package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.repository.IOdontologoRepository;
import com.dh.ClinicMVC.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarPorId(Long id) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()) {
            return odontologoOptional;
        } else {
            return null;
        }
    }
    @Override
    public Optional<Odontologo> buscarPorNombre(String nombre) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.buscarOdontologoPorNombre(nombre);
        if(odontologoOptional.isPresent()) {
            return odontologoOptional;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Odontologo> buscarPorApellido(String apellido) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.buscarOdontologoPorApellido(apellido);
        if(odontologoOptional.isPresent()) {
            return odontologoOptional;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Odontologo> buscarPorMatricula(String matricula) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.buscarOdontologoPorMatriucula(matricula);
        if(odontologoOptional.isPresent()) {
            return odontologoOptional;
        } else {
            return null;
        }
    }


    @Override
    public void eliminar(Odontologo odontologo){odontologoRepository.delete(odontologo);}
    @Override
    public void actualizar(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }
}
