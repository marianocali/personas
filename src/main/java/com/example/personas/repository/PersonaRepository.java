package com.example.personas.repository;

import com.example.personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, CriteriaBuilder.In> {
    Persona findById(Integer idPersona);

    @Query(" SELECT P FROM Persona P " +
            " WHERE P.tipoDocumento = :tipoDoc " +
            " AND P.nroDocumento = :nroDoc" +
            " AND P.pais = :pais")
    Optional <Persona> getPersonaByDocumento(
            @Param("tipoDoc") String tipoDoc,
            @Param("nroDoc") String nroDoc,
            @Param("pais") String pais);

}
