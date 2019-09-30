/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOUsuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Brayan Sebastian
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable{

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }
    public void validarSesion(){
        try{
            FacesContext faces = FacesContext.getCurrentInstance();
            DTOUsuario user = (DTOUsuario) faces.getExternalContext().getSessionMap().get("usuario");
            if(user == null){
                faces.getExternalContext().redirect("./../login.xhtml");
            } else if(!user.getRol().equals("Cliente")){
                System.out.println(user.getRol());
                faces.getExternalContext().redirect("/inicio.xhtml");
            }
 
        } catch (Exception e){
          System.err.println("Error: " + e.getMessage());
        }
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}
