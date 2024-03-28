package com.dh.ClinicMVC.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {
    private String nombre;
    private String apellido;
    private String matricula;
}
