package com.prueba.sesion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String rolName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", rolName=" + rolName + '}';
    }
    
    
}
