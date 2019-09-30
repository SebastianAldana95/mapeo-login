/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.interfaces.InversorFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Brayan Sebastian
 */
@Named(value = "administradorController")
@SessionScoped
public class AdministradorController implements Serializable{
    
    private DTOUsuario user;
    private String nombre;
    private String cuenta;
    private String nombreuser;
    private String username;
    private String password;
    private String rol;
    
    @EJB
    InversorFacadeLocal inversorCon;
    
    @EJB
    IUsuarioFacade usuarioEJB;
    
    /**
     * Creates a new instance of AdministradorController
     */
    public AdministradorController() {
    }
    
    public void validarSesion(){
        try{
            FacesContext faces = FacesContext.getCurrentInstance();
            DTOUsuario user = (DTOUsuario) faces.getExternalContext().getSessionMap().get("usuario");
            if(user == null){
                faces.getExternalContext().redirect("./../login.xhtml");
            } else if(!user.getRol().equals("Administrador")){
                System.out.println(user.getRol());
            }
 
        } catch (Exception e){
          System.err.println("Error: " + e.getMessage());
        }
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    
    public void agregarInversor(){
        DTOInversor dtoInversor = new DTOInversor();
        DTOCuenta dtoCuenta = new DTOCuenta();
        dtoInversor.setNombre(nombre);
        dtoCuenta.setNumeroCuenta(cuenta);
        inversorCon.crearInversor(dtoInversor, dtoCuenta);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
            "inversor"+nombre+"Agregado Correctamente!"));
    }
    
    public void agregarUsuario(){
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setNombres(nombreuser);
        dtoUsuario.setUser(username);
        dtoUsuario.setPassword(password);
        //dtoUsuario.setPassword(hash.md5(password));
        dtoUsuario.setRol(rol);
        usuarioEJB.crearUsuario(dtoUsuario);
        
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Agregado",
            "usuario"+nombreuser+"Agregado Correctamente!")); 
            
            
    }

    public DTOUsuario getUser() {
        return user;
    }

    public void setUser(DTOUsuario user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
