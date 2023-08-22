package com.prueba.sesion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="Usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String mail;
    private String sessionActive;
    private String status;
    
    @ManyToOne
    private Persona persona_idPersona2;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(String sessionActive) {
        this.sessionActive = sessionActive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Persona getPersona_idPersona2() {
        return persona_idPersona2;
    }

    public void setPersona_idPersona2(Persona persona_idPersona2) {
        this.persona_idPersona2 = persona_idPersona2;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", mail=" + mail + ", sessionActive=" + sessionActive + ", status=" + status + ", persona_idPersona2=" + persona_idPersona2 + '}';
    }   
    
    
}
