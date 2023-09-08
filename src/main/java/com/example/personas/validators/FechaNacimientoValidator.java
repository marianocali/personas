package com.example.personas.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class FechaNacimientoValidator {

    final static int MAYOR_EDAD = 18;
    public boolean validateAge(LocalDate fechaNacimiento) {
        Period period = Period.between(fechaNacimiento, LocalDate.now());
        if (period.getYears() >= MAYOR_EDAD){
            return true;
        }else {
            throw new RuntimeException("Age must be greater than 18");
        }
    }

}
