package com.prueba.sesion.service;

import com.prueba.sesion.model.RolOpciones;
import com.prueba.sesion.repositorio.RolOpcionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolOpcionesService {
    
    private final RolOpcionesRepository rolOpcionesRepository;
    
    @Autowired
    public RolOpcionesService(RolOpcionesRepository rolOpcionesRepository) {
        this.rolOpcionesRepository = rolOpcionesRepository;
    }
    
    public List<RolOpciones> obtenerOpcionesRol(){
        return rolOpcionesRepository.findAll();
    }
    
    public RolOpciones obtenerOpcionRol(int id){
        return rolOpcionesRepository.findById(id).get();
    }
    
    public RolOpciones obtenerRolPorNombre(String nombre){
        return rolOpcionesRepository.findByNombreOpcion(nombre);
    }
}
