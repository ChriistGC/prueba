package com.prueba.sesion.service;

import com.prueba.sesion.model.Sessions;
import com.prueba.sesion.model.Usuarios;
import com.prueba.sesion.repositorio.SessionsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionsService {
    
    private final SessionsRepository sessionsRepository;
    private final UsuariosService usuariosService;
    
    @Autowired
    public SessionsService(SessionsRepository sessionsRepository, UsuariosService usuariosService) {
        this.sessionsRepository = sessionsRepository;
        this.usuariosService = usuariosService;
    }
    
    public List<Sessions> obtenerSesiones(String userName){
        Usuarios user = usuariosService.obtenerUsuarioPorNombre(userName);
        return sessionsRepository.findByUsuarios(user);
    }
    
}
