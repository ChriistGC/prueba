package com.prueba.sesion.service;

import com.prueba.sesion.model.Rol;
import com.prueba.sesion.model.RolOpciones;
import com.prueba.sesion.repositorio.RolRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    
    private final RolRepository rolRepository;
    private final RolOpcionesService rolOpcionesService;
    private final RolRolOpcionesService rolRolOpcionesService;
    
    @Autowired
    public RolService(RolRepository rolRepository, RolRolOpcionesService rolRolOpcionesService, RolOpcionesService rolOpcionesService) {
        this.rolRepository = rolRepository;
        this.rolOpcionesService = rolOpcionesService;
        this.rolRolOpcionesService = rolRolOpcionesService;
    }
    
    public Rol asignarRol(){
        try{
            RolOpciones rolOpciones = rolOpcionesService.obtenerRolPorNombre("usuario");
            Rol rol = new Rol();
            rol.setRolName(rolOpciones.getNombreOpcion());
            
            rolRepository.save(rol);
            
            rolRolOpcionesService.asignarOpcionRol(rol, rolOpciones);
            return rol;
        }catch(Exception e){
            return null;
        }
    }
    
    public Rol obtenerRol(int id){
        return rolRepository.findById(id).get();
    }
}
