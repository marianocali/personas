package com.example.personas.service;

import com.example.personas.model.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona>getPersonas();

    Persona save(Persona persona);

    Persona update(Persona persona);

    String relacionarPersonas(Integer idPersona1, Integer idPersona2);

    void delete(Integer personaId);
}
