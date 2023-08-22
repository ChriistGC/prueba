package com.prueba.sesion.service;

import com.prueba.sesion.model.Persona;
import com.prueba.sesion.repositorio.PersonaRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    private final PersonaRepository personaRepository;
    private final ValidacionService validacionService;
    
    @Autowired
    public PersonaService(PersonaRepository personaRepository, ValidacionService validacionService) {
        this.personaRepository = personaRepository;
        this.validacionService = validacionService;
    }
    
    public ResponseEntity<Object> crearPersona (Persona persona){
        try{
            boolean verificarIdentificacion = validacionService.validateIdentification(persona.getIdentificación());
            
            if(verificarIdentificacion){
                personaRepository.save(persona);
                
                return ResponseEntity.created(new URI("/persona/" + persona.getId())).body(persona);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Datos Invalidos");
            }
            
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    
    
}
