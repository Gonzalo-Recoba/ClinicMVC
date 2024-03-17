package com.dh.ClinicMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnoSet = new HashSet<>();
//
//    public Paciente(Integer id, String nombre, String apellido, String dni, LocalDate fechaAlta, Domicilio domicilio) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.dni = dni;
//        this.fechaIngreso = fechaAlta;
//        this.domicilio = domicilio;
//    }
//
//    public Paciente(String nombre, String apellido, String dni, LocalDate fechaAlta, Domicilio domicilio) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.dni = dni;
//        this.fechaIngreso = fechaAlta;
//        this.domicilio = domicilio;
//    }
//
//    public Paciente() {
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
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String getDni() {
//        return dni;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
//
//    public LocalDate getFechaIngreso() {
//        return fechaIngreso;
//    }
//
//    public void setFechaIngreso(LocalDate fechaIngreso) {
//        this.fechaIngreso = fechaIngreso;
//    }
//
//    public Domicilio getDomicilio() {
//        return domicilio;
//    }
//
//    public void setDomicilio(Domicilio domicilio) {
//        this.domicilio = domicilio;
//    }
}
