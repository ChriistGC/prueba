package com.prueba.sesion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RolUsuariosId implements Serializable{
    
    @Column(name="rol_id")
    private int rolId;
    
    @Column(name="usuarios_id")
    private int usuariosId;

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }
    
    
}
