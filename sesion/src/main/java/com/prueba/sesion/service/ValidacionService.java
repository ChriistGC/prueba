package com.prueba.sesion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ValidacionService {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ValidacionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean validateUsername(String username) {
        String query = "SELECT validate_username(?)";
        return jdbcTemplate.queryForObject(query, Boolean.class, username);
    }

    public boolean validatePassword(String password) {
        String query = "SELECT validate_password(?)";
        return jdbcTemplate.queryForObject(query, Boolean.class, password);
    }

    public boolean validateIdentification(String identification) {
        String query = "SELECT validate_identification(?)";
        return jdbcTemplate.queryForObject(query, Boolean.class, identification);
    }
    
}
