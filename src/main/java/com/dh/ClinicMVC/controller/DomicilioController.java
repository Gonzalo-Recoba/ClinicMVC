package com.dh.ClinicMVC.controller;
import com.dh.ClinicMVC.entity.Domicilio;
import com.dh.ClinicMVC.entity.Paciente;
import com.dh.ClinicMVC.entity.Turno;
import com.dh.ClinicMVC.service.IDomicilioService;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.IPacienteService;
import com.dh.ClinicMVC.service.ITurnoService;
import com.dh.ClinicMVC.service.implementation.DomicilioService;
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
@RequestMapping("/domicilios")
public class DomicilioController {
    private IDomicilioService domicilioService;

    @Autowired
    public DomicilioController(DomicilioService domicilioService){this.domicilioService = domicilioService;}

    @GetMapping("/id{id}")
    public ResponseEntity<Optional<Domicilio>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(domicilioService.buscarPorId(id));
    }

    @GetMapping("/calle={calle}")
    public ResponseEntity<Optional<Domicilio>> buscarPorCalle(@PathVariable String calle) {
        return ResponseEntity.ok(domicilioService.buscarPorCalle(calle));
    }

    @GetMapping("/numero={numero}")
    public ResponseEntity<Optional<Domicilio>> buscarPorNumero(@PathVariable Integer numero){
        return ResponseEntity.ok(domicilioService.buscarPorNumero(numero));
    }

    @GetMapping("/localidad={localidad}")
    public ResponseEntity<Optional<Domicilio>> buscarPorLocalidad(@PathVariable String localidad){
        return ResponseEntity.ok(domicilioService.buscarPorLocalidad(localidad));
    }


    @GetMapping("/provincia={provincia}")
    public ResponseEntity<Optional<Domicilio>> buscarPorProvincia(@PathVariable String provincia){
        return ResponseEntity.ok(domicilioService.buscarPorProvincia(provincia));
    }

    @PostMapping
    public ResponseEntity<Domicilio> guardar(@RequestBody Domicilio domicilio) {
        return ResponseEntity.ok(domicilioService.guardar(domicilio));
    }

    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Domicilio domicilio) {
        ResponseEntity<String> response;
        Optional<Domicilio> domicilioOptional = domicilioService.buscarPorId(domicilio.getId());
        if (domicilioOptional != null) {
            domicilioService.actualizar(domicilio);
            response = ResponseEntity.ok("Se actualizó el domicilio con id " + domicilio.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el domicilio");
        }
        return response;
    }

    @DeleteMapping()
    public ResponseEntity<String> eliminar(@RequestBody Domicilio domicilio) {
        ResponseEntity<String> response;
        Optional<Domicilio> domicilioOptional = domicilioService.buscarPorId(domicilio.getId());
        if (domicilioOptional != null) {
            domicilioService.eliminar(domicilio);
            response = ResponseEntity.ok("Se elimino el domicilio con id " + domicilio.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede eliminar el domicilio");
        }
        return response;
    }
}
