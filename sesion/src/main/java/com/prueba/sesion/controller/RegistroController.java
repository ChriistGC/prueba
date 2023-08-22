package com.prueba.sesion.controller;

import com.prueba.sesion.model.Usuarios;
import com.prueba.sesion.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/registro")
public class RegistroController {
    
    private final RegistroService registroService;
    
    @Autowired
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }
    
    @PostMapping
    private ResponseEntity<Object> guardar (@RequestBody Usuarios user){
        return registroService.create(user);
    }
    
    @GetMapping
    private Usuarios iniarSesion(String usuario, String password){
        return registroService.iniciarSesion(usuario, password);
    }
    
    
    
}
