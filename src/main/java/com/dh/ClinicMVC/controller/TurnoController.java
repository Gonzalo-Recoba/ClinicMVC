package com.dh.ClinicMVC.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    //endpoint para guardar un turno
    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;

        LOGGER.info("esto trae el turno: " + turno);
//        vamos a chequear que exista el odontologo y la paciente
        if (odontologoService.buscarPorId(turno.getOdontologo().getId()) != null &&
                pacienteService.buscarPorId(turno.getPaciente().getId()) != null) {

            //setear una respuesta en 200 y vamos a hacer que devuelva el turno
            response = ResponseEntity.ok(turnoService.guardar(turno));

        } else {
            //si no existe el odontologo o el paciente
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }
}
