package com.example.personas.service;

import com.example.personas.model.Relacion;
import com.example.personas.repository.RelacionesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelacionServiceImpl implements RelacionService{

    RelacionesRepository relacionesRepository;

    public RelacionServiceImpl(RelacionesRepository relacionesRepository){
        this.relacionesRepository = relacionesRepository;
    }

    @Override
    public String getRelacion(Integer idPersona1, Integer idPersona2) {
        Optional<Relacion> relacion = Optional.ofNullable(relacionesRepository.findPersonasById(idPersona1,idPersona2));
        if(relacion.isPresent()){
            return "hay relacion entre " + idPersona1 + " e " + idPersona2;
        }
        return "no hay relacion entre "+ idPersona1 + " e " + idPersona2;
    }
}
