package com.dh.ClinicMVC.dto;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.entity.Paciente;
import lombok.Getter;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fecha;
}
