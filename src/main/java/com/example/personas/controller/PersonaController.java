package com.example.personas.controller;

import com.example.personas.model.Persona;
import com.example.personas.service.PersonaService;
import com.example.personas.validators.FechaNacimientoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;
    private final FechaNacimientoValidator fechaNacimientoValidator;

    public PersonaController(PersonaService personaService, FechaNacimientoValidator fechaNacimientoValidator) {
        this.personaService = personaService;
        this.fechaNacimientoValidator = fechaNacimientoValidator;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas() {
        return ResponseEntity.ok(personaService.getPersonas());
    }

    @PostMapping("/")
    public ResponseEntity<Persona> savePersona(@Valid @RequestBody Persona persona) {
        fechaNacimientoValidator.validateAge(persona.getFechaNacimiento());
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@Valid @RequestBody Persona persona) {
        fechaNacimientoValidator.validateAge(persona.getFechaNacimiento());
        return ResponseEntity.ok(personaService.update(persona));
    }

    @DeleteMapping("/{personaId}")
    public ResponseEntity<String> deletePersona(@PathVariable Integer personaId) {
        personaService.delete(personaId);
        return ResponseEntity.ok("La persona con id " + personaId + " ha sido borrada");
    }

    @PostMapping("{personaId1}/relacion/{personaId2}")
    public ResponseEntity<String> relacionarPersonas(@PathVariable Integer personaId1, @PathVariable Integer personaId2){
        return ResponseEntity.ok(personaService.relacionarPersonas(personaId1,personaId2));
    }
}
