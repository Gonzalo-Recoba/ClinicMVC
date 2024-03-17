package com.dh.ClinicMVC.service.implementation;

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
    public void eliminar(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    @Override
    public void actualizar(Paciente paciente){
        pacienteRepository.save(paciente);
    }














//    private IDao<Paciente> pacienteIDao;
//
//    public PacienteService(IDao<Paciente> pacienteIDao) {
//        this.pacienteIDao = pacienteIDao;
//    }
//
//    @Override
//    public Paciente guardar(Paciente paciente) {
//        return pacienteIDao.guardar(paciente);
//    }
//
//    @Override
//    public List<Paciente> listarTodos() {
//        return null;
//    }
//
//    @Override
//    public Paciente buscarPorId(Integer id) {
//        return pacienteIDao.buscarPorId(id);
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//
//    }
//
//    @Override
//    public void actualizar(Paciente paciente) {
//
//    }
}
