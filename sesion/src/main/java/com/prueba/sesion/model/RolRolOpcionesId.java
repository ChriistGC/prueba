package com.prueba.sesion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RolRolOpcionesId implements Serializable{
    
    @Column(name = "rol_id")
    private int rolId;
    
    @Column(name = "rol_Opciones_Id")
    private int rolOpcionesId;

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getRolOpcionesId() {
        return rolOpcionesId;
    }

    public void setRolOpcionesId(int rolOpcionesId) {
        this.rolOpcionesId = rolOpcionesId;
    }
    
    
    
    
}
