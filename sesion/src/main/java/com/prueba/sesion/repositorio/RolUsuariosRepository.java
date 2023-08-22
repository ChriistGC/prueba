package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.RolUsuarios;
import com.prueba.sesion.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUsuariosRepository extends JpaRepository<RolUsuarios, Usuarios> {
    
}
