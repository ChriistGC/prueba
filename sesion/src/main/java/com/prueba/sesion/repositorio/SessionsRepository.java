package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.Sessions;
import com.prueba.sesion.model.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionsRepository extends JpaRepository<Sessions, Usuarios>{
    
    List<Sessions> findByUsuarios (Usuarios user);
}
