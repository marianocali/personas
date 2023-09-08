package com.example.personas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Persona already exists")
public class PersonaAlreadyExistsException extends RuntimeException {

    private String errorDescription;

    public PersonaAlreadyExistsException(){}

    public PersonaAlreadyExistsException(String errorDescription){
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
