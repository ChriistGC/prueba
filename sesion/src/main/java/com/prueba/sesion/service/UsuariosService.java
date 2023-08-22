package com.prueba.sesion.service;

import com.prueba.sesion.model.Usuarios;
import com.prueba.sesion.repositorio.UsuariosRepository;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    
    private final UsuariosRepository usuariosRepository;
    private final PersonaService personaService;
    private final ValidacionService validacionService;
    
    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository, PersonaService personaService, ValidacionService validacionService) {
        this.usuariosRepository = usuariosRepository;
        this.personaService = personaService;
        this.validacionService = validacionService;
    }
    
    public Usuarios crearUsuario (Usuarios user){
        try{
            boolean verificarUser = validacionService.validateUsername(user.getUserName());
            boolean verificarPass = validacionService.validatePassword(user.getUserName());
            if(verificarUser && verificarPass){
                
                //Genera Email
                String mail = generateEmail(user);
                user.setMail(mail);
                
                personaService.crearPersona(user.getPersona_idPersona2());
                usuariosRepository.save(user);
                return user;
            }else{
                return null;
            }
            
        }catch(Exception e){
            return null;
        }
    }
    
    public Usuarios obtenerUsuarioPorNombre(String nombre){
        return usuariosRepository.findByUserName(nombre);
    }
    
    public Usuarios obtenerUsuarioPorMail(String mail){
        return usuariosRepository.findByMail(mail);
    }
    
    public String generateEmail(Usuarios user) {
        String nombres = user.getPersona_idPersona2().getNombres();
        String apellidos = user.getPersona_idPersona2().getApellidos();
        
        //Eliminar espacio
        String [] nombresP = nombres.split(" ");
        String [] apellidosP = apellidos.split(" ");
        
        String baseEmail = (nombresP[0].substring(0, 1) 
                + apellidosP[0]+apellidosP[1].substring(0,1)).toLowerCase() + "@mail.com";
        String generatedEmail = baseEmail;

        int number = 1;
        
        while(usuariosRepository.existsByMail(baseEmail)){
            generatedEmail = baseEmail +number;
            number ++;
        }

        return generatedEmail;

    }
    
    
}
