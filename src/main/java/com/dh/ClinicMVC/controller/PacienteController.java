package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.entity.Domicilio;
import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.entity.Paciente;
import com.dh.ClinicMVC.service.IDomicilioService;
import com.dh.ClinicMVC.service.IPacienteService;
import com.dh.ClinicMVC.service.implementation.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    //Buscar por id
    @GetMapping("/id{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    //Buscar por nombre
    @GetMapping("/nombre={nombre}")
    public ResponseEntity<Optional<Paciente>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(pacienteService.buscarPorNombre(nombre));
    }

    //Buscar por apellido
    @GetMapping("/apellido={apellido}")
    public ResponseEntity<Optional<Paciente>> buscarPorApellido(@PathVariable String apellido) {
        return ResponseEntity.ok(pacienteService.buscarPorApellido(apellido));
    }


    //Buscar por DNI
    @GetMapping("/dni={dni}")
    public ResponseEntity<Optional<Paciente>> buscarPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(pacienteService.buscarPorDni(dni));
    }


    //Guardar un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }


    //Listar todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }


    //Actualizar un paciente
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<String> response;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(paciente.getId());
        if (pacienteBuscado != null) {
            pacienteService.actualizar(paciente);
            response = ResponseEntity.ok("Se actualizó el paciente con id " + paciente.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el paciente");
        }
        return response;
    }


    //Eliminar un paciente
    @DeleteMapping()
    public ResponseEntity<String> eliminar(@RequestBody Paciente paciente) {
        ResponseEntity<String> response;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(paciente.getId());
        if (pacienteBuscado != null) {
            pacienteService.eliminar(paciente);
            response = ResponseEntity.ok("Se elimino el paciente con id " + paciente.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede eliminar el paciente");
        }
        return response;
    }
}


