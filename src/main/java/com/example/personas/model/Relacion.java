package com.example.personas.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "relacion")
public class Relacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;


    @Column
    private Integer idPersona1;

    @Column
    private Integer idPersona2;

    public Relacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPersona1() {
        return idPersona1;
    }

    public void setIdPersona1(Integer idPersona1) {
        this.idPersona1 = idPersona1;
    }

    public Integer getIdPersona2() {
        return idPersona2;
    }

    public void setIdPersona2(Integer idPersona2) {
        this.idPersona2 = idPersona2;
    }


}
