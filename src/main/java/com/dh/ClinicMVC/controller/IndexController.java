package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.implementation.OdontologoService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Controller
@RequestMapping("/odontologo")
public class IndexController {

    private IOdontologoService odontologoService;

    public IndexController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @GetMapping
    public String buscarOdontologoPorId(Model model, @RequestParam Long id, @RequestParam String nombre) {
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre", odontologo.get().getNombre());
        model.addAttribute("apellido", odontologo.get().getApellido());
        return "buscarOdontologo";
    }

    @GetMapping("/{id}")
    public String buscarOdontologoPorIdVariable(Model model, @PathVariable Long id) {
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre", odontologo.get().getNombre());
        model.addAttribute("apellido", odontologo.get().getApellido());
        return "buscarOdontologo";
    }

}
