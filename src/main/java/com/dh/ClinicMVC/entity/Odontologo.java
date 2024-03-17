package com.dh.ClinicMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnoSet = new HashSet<Turno>();

//    public Odontologo() {
//    }
//
//    public Odontologo(Integer id, String nombre, String apellido, String matricula) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.matricula = matricula;
//    }
//
//    public Odontologo(String nombre, String apellido, String matricula) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.matricula = matricula;
//    }
//
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
//    public String getMatricula() {
//        return matricula;
//    }
//
//    public void setMatricula(String matricula) {
//        this.matricula = matricula;
//    }
}
