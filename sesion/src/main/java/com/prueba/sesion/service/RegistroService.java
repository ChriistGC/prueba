package com.prueba.sesion.service;

import com.prueba.sesion.model.Rol;
import com.prueba.sesion.model.RolUsuarios;
import com.prueba.sesion.model.Usuarios;
import com.prueba.sesion.repositorio.RolUsuariosRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    
    private final RolUsuariosRepository rolUsuariosRepository;
    private final UsuariosService usuariosService;
    private final RolService rolService;

    @Autowired
    public RegistroService(RolUsuariosRepository rolUsuariosRepository, UsuariosService usuariosService, RolService rolService) {
        this.rolUsuariosRepository = rolUsuariosRepository;
        this.usuariosService = usuariosService;
        this.rolService = rolService;
    }
    
    public ResponseEntity<Object> create(Usuarios usuarios) {
        try {
            RolUsuarios rolUsuarios = new RolUsuarios();
            Rol rol = rolService.asignarRol();
            
            rolUsuarios.setRol(rol);
            usuarios = usuariosService.crearUsuario(usuarios);
            rolUsuarios.setUsuarios(usuarios);
            
            rolUsuariosRepository.save(rolUsuarios);
            return ResponseEntity.created(new URI("/registro/" + rolUsuarios.getUsuarios())).body(rolUsuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se registró el Usuario");
        }

    }
    
    public Usuarios iniciarSesion(String name, String pass){
        Usuarios user = usuariosService.obtenerUsuarioPorNombre(name);
        
        if(user==null){
            user = usuariosService.obtenerUsuarioPorMail(name);
        }
        
        if(user!=null && pass.equals(user.getPassword())){
            return user;
        } else{
            return null;
        }
    }
    
    
    
    
}
