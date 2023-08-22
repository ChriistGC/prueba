package com.prueba.sesion.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rol_rol_opciones")
public class RolRolOpciones implements Serializable{
    
    @EmbeddedId
    private RolRolOpcionesId id;
    
    @ManyToOne
    @JoinColumn(name = "rol_id", insertable=false, updatable=false)
    private Rol rol;
    
    @ManyToOne
    @JoinColumn(name = "rol_opciones_id", insertable=false, updatable=false)
    private RolOpciones rolOpciones;    

    public RolRolOpcionesId getId() {
        return id;
    }

    public void setId(RolRolOpcionesId id) {
        this.id = id;
    }
    
    

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }

    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

    @Override
    public String toString() {
        return "RolRolOpciones{" + "rol=" + rol + ", rolOpciones=" + rolOpciones + '}';
    }
    
    
    
}
