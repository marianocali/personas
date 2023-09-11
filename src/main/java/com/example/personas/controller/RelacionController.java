package com.example.personas.controller;

import com.example.personas.service.RelacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relaciones")
public class RelacionController {

    RelacionService relacionService;

    public RelacionController(RelacionService relacionService){
        this.relacionService = relacionService;
    }

    @GetMapping("{personaId1}/{personaId2}")
    public ResponseEntity<String> getRelacion(@PathVariable Integer personaId1, @PathVariable Integer personaId2){
        return ResponseEntity.ok(relacionService.getRelacion(personaId1,personaId2));
    }
}
