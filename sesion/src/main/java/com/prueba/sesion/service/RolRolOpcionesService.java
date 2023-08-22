package com.prueba.sesion.service;

import com.prueba.sesion.model.Rol;
import com.prueba.sesion.model.RolOpciones;
import com.prueba.sesion.model.RolRolOpciones;
import com.prueba.sesion.repositorio.RolRolOpcionesRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolRolOpcionesService {
    
    private final RolRolOpcionesRepository rolRolOpcionesRepository;
    
    @Autowired
    public RolRolOpcionesService(RolRolOpcionesRepository rolRolOpcionesRepository) {
        this.rolRolOpcionesRepository = rolRolOpcionesRepository;
    }
    
    public ResponseEntity<Object> asignarOpcionRol (Rol rol, RolOpciones rolOpciones){
        try{
            RolRolOpciones rolRolOpciones  = new  RolRolOpciones();
            rolRolOpciones.setRol(rol);
            rolRolOpciones.setRolOpciones(rolOpciones);
            
            rolRolOpcionesRepository.save(rolRolOpciones);
            return ResponseEntity.created(new URI("/opcionesrol/"+ rolRolOpciones.getRol())).body(rolRolOpciones);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
