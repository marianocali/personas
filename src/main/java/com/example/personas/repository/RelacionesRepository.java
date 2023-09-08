package com.example.personas.repository;

import com.example.personas.model.Relacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionesRepository extends JpaRepository<Relacion, Integer> {
    @Query("SELECT r FROM Relacion r " +
            "WHERE r.idPersona1 = :idPersona1 " +
            "AND r.idPersona2 = :idPersona2")
    Relacion findPersonasById(
            @Param ("idPersona1") Integer idPersona1,
            @Param ("idPersona2") Integer idPersona2);
}
