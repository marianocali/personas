package com.example.personas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Persona Not Found")
public class PersonaNotFoundException extends RuntimeException {

    private String errorDescription;

    public PersonaNotFoundException(){}

    public PersonaNotFoundException(String errorDescription){
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}