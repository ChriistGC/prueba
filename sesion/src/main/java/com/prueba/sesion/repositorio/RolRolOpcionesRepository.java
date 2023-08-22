package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.Rol;
import com.prueba.sesion.model.RolRolOpciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRolOpcionesRepository extends JpaRepository<RolRolOpciones, Rol>{
    
}
