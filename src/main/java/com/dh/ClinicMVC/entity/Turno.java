package com.dh.ClinicMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "turnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Odontologo odontologo;
    @ManyToOne
    private Paciente paciente;
    private LocalDate fecha;

//    public Turno(Integer id, Odontologo odontologo, Paciente paciente, LocalDate fecha) {
//        this.id = id;
//        this.odontologo = odontologo;
//        this.paciente = paciente;
//        this.fecha = fecha;
//    }
//
//    public Turno() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Odontologo getOdontologo() {
//        return odontologo;
//    }
//
//    public void setOdontologo(Odontologo odontologo) {
//        this.odontologo = odontologo;
//    }
//
//    public Paciente getPaciente() {
//        return paciente;
//    }
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    }
//
//    public LocalDate getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(LocalDate fecha) {
//        this.fecha = fecha;
//    }
}
