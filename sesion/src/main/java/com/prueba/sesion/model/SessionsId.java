package com.prueba.sesion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SessionsId implements Serializable{
    
    @Column(name="usuarios_id")
    private int usuariosId;

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }
    
        
    
}
