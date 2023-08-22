package com.prueba.sesion.repositorio;

import com.prueba.sesion.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    
    @Procedure(name ="validate_username")
    boolean validarUsuario(@Param("user_name") String usuario);
    
    @Procedure(name="validate_password")
    boolean validarPassword(@Param("password") String password);
    
    Usuarios findByUserName (String username);
    
    boolean existsByMail(String mail);
    
    Usuarios findByMail (String mail);
    
}
