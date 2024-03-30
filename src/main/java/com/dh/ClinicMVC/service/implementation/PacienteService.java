package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.entity.Paciente;
import com.dh.ClinicMVC.repository.IPacienteRepository;
import com.dh.ClinicMVC.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            return pacienteOptional;
        }
        return null;
    }

    @Override
    public Optional<Paciente> buscarPorNombre(String nombre) {
        Optional<Paciente> pacienteOptional = pacienteRepository.buscarPacientePorNombre(nombre);
        if(pacienteOptional.isPresent()) {
            return pacienteOptional;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Paciente> buscarPorApellido(String apellido) {
        Optional<Paciente> pacienteOptional = pacienteRepository.buscarPacientePorApellido(apellido);
        if(pacienteOptional.isPresent()) {
            return pacienteOptional;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Paciente> buscarPorDni(String dni) {
        Optional<Paciente> pacienteOptional = pacienteRepository.buscarPacientePorDni(dni);
        if(pacienteOptional.isPresent()) {
            return pacienteOptional;
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    @Override
    public void actualizar(Paciente paciente){
        pacienteRepository.save(paciente);
    }
}
