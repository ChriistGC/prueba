package com.prueba.sesion.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="rol_usuarios")
public class RolUsuarios implements Serializable{
    
    @EmbeddedId
    private RolUsuariosId id;
    
    @ManyToOne
    @JoinColumn(name = "rol_id", insertable=false, updatable=false)
    private Rol rol;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id", insertable=false, updatable=false)
    private Usuarios usuarios;

    public RolUsuariosId getId() {
        return id;
    }

    public void setId(RolUsuariosId id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "RolUsuarios{" + "rol=" + rol + ", usuarios=" + usuarios + '}';
    }
    
}
