package com.prueba.sesion.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="sessions")
public class Sessions{
    
    @EmbeddedId
    private SessionsId id;
    
    private Date fechaIngreso;
    private Date fechaCierre;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id", insertable=false, updatable=false)
    private Usuarios usuarios;

    public SessionsId getId() {
        return id;
    }

    public void setId(SessionsId id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
