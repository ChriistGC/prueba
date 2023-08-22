package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.RolOpciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolOpcionesRepository extends JpaRepository<RolOpciones, Integer>{
    
    RolOpciones findByNombreOpcion(String nombre);
}
