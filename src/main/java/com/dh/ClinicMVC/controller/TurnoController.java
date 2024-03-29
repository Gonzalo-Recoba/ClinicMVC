package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.entity.Paciente;
import com.dh.ClinicMVC.entity.Turno;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.IPacienteService;
import com.dh.ClinicMVC.service.ITurnoService;
import com.dh.ClinicMVC.service.implementation.OdontologoService;
import com.dh.ClinicMVC.service.implementation.PacienteService;
import com.dh.ClinicMVC.service.implementation.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger LOGGER = Logger.getLogger(TurnoController.class);

    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //Listar todos los turnos
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(turnoService.listarTodos());
    }


    //Guardar un turno
    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;

        if (odontologoService.buscarPorId(turno.getOdontologo().getId()) != null &&
                pacienteService.buscarPorId(turno.getPaciente().getId()) != null) {

            response = ResponseEntity.ok(turnoService.guardar(turno));

        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }


    //Actualizar un odontologo
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Turno turno) {
        ResponseEntity<String> response;
        Optional<Turno> turnoOptional = turnoService.buscarPorId(turno.getId());
        if (turnoOptional != null) {
            turnoService.actualizar(turno);
            response = ResponseEntity.ok("Se actualizó el turno con id " + turno.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el turno");
        }
        return response;
    }


    //Eliminar un paciente
    @DeleteMapping
    public ResponseEntity<String> eliminar(@RequestBody Turno turno) {
        ResponseEntity<String> response;
        Optional<Turno> turnoOptional = turnoService.buscarPorId(turno.getId());
        if (turnoOptional != null) {
            turnoService.eliminar(turno);
            response = ResponseEntity.ok("Se elimino el turno con id " + turno.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede eliminar el turno");
        }
        return response;
    }


}