package com.example.personas.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    @NotEmpty(message = "nombre no puede ser nulo ni vacio")
    private String name;

    @Column
    @NotEmpty(message = "tipo de documento no puede ser nulo ni vacio")
    private String tipoDocumento;

    @Column
    @NotEmpty(message = "número de documento no puede ser nula ni vacio")
    @Digits(integer = 9, fraction = 0)
    private String nroDocumento;

    @Column
    @NotEmpty(message = "país no puede ser nulo ni vacio")
    private String pais;

    @Column
    private LocalDate fechaNacimiento;

    @Column
    @Valid
    @NotEmpty(message = "telefono no puede ser nulo ni vacio")
    private String telefono;

    public Persona(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
