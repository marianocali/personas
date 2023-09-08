package com.example.personas.service;

import com.example.personas.error.PersonaAlreadyExistsException;
import com.example.personas.error.PersonaNotFoundException;
import com.example.personas.model.Persona;
import com.example.personas.model.Relacion;
import com.example.personas.repository.PersonaRepository;
import com.example.personas.repository.RelacionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    private PersonaRepository personaRepository;
    private RelacionesRepository relacionesRepository;

    PersonaServiceImpl(PersonaRepository personaRepository, RelacionesRepository relacionesRepository){
        this.personaRepository = personaRepository;
        this.relacionesRepository = relacionesRepository;
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        Optional<Persona> optPersona = personaRepository.getPersonaByDocumento(
                persona.getTipoDocumento(),
                persona.getNroDocumento(),
                persona.getPais());
       if(optPersona.isPresent()){
           throw new PersonaAlreadyExistsException("La persona con tipo de documento "
                   + persona.getTipoDocumento()
                   + " y número de documento " + persona.getNroDocumento()
                   + " y país" + persona.getPais() + " ya existe");
       }
       return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        Optional<Persona> optPersona = Optional.ofNullable(personaRepository.findById(persona.getId()));
        if(!optPersona.isPresent()){
            throw new PersonaNotFoundException("La persona con id " + persona.getId() + " no ha sido encontrada.");
        }
        return personaRepository.save(persona);
    }

    @Override
    public String relacionarPersonas(Integer idPersona1, Integer idPersona2) {

        Optional<Persona> optPersona1 = Optional.ofNullable(personaRepository.findById(idPersona1));
        if(optPersona1.isEmpty()){
            throw new PersonaNotFoundException("La persona con id " + idPersona1 + " no ha sido encontrada.");
        }
        Optional<Persona> optPersona2 = Optional.ofNullable(personaRepository.findById(idPersona2));
        if(optPersona2.isEmpty()){
            throw new PersonaNotFoundException("La persona con id " + idPersona2 + " no ha sido encontrada.");
        }
        Optional<Relacion> relacionOpt = Optional.ofNullable(relacionesRepository.findPersonasById(idPersona1,idPersona2));
        if(relacionOpt.isEmpty()){
            Relacion relacion = new Relacion();
            relacion.setIdPersona1(idPersona1);
            relacion.setIdPersona2(idPersona2);
            relacionesRepository.save(relacion);
        }
        return ":" + idPersona1 + " esta relacionado con:" + idPersona2;
    }

    @Override
    public void delete(Integer idPersona) {
        Optional<Persona> optPersona = Optional.ofNullable(personaRepository.findById(idPersona));
        if(!optPersona.isPresent()){
            throw new PersonaNotFoundException("La persona con id " + idPersona + " no ha sido encontrada.");
        }
        personaRepository.delete(optPersona.get());
    }
}
