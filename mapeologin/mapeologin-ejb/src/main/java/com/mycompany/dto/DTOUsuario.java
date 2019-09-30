/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 *
 * @author Brayan Sebastian
 */
public class DTOUsuario implements Serializable{
    
    private int id;
    private String nombres;
    private String user;
    private String password;
    private String rol;

    public DTOUsuario() {
    }
    /**
     * 
     * @param nombres
     * @param user
     * @param password
     * @param rol 
     */
    
    public DTOUsuario(String nombres, String user, String password, String rol) {
        this.nombres = nombres;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public DTOUsuario(int id, String nombres, String user, String password, String rol) {
        this.id = id;
        this.nombres = nombres;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }
    
    
    /**
     * 
     * @return 
     */
    public String getNombres() {
        return nombres;
    }
    /**
     * 
     * @param nombres 
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * 
     * @return 
     */
    public String getUser() {
        return user;
    }
    /**
     * 
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 
     * @return 
     */
    public String getRol() {
        return rol;
    }
    /**
     * 
     * @param rol 
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
