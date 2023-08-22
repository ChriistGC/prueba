package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
    @Procedure("validate_identification")
    Boolean validateIdentification(@Param("identificacion") String identification);
}
