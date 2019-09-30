/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;


import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.ILoginSesion;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Brayan Sebastian
 */
@Named(value="loginController")
@RequestScoped
public class LoginController implements Serializable{

    private List<DTOUsuario> lUsuario;
    private String username;
    private String password;
    
    @EJB
    IUsuarioFacade ejbUsuario;
    
    public LoginController() {        
        lUsuario = new ArrayList();
    }
   
    /**
     * metodo que trae datos para iniciar sesion
     */
    /**
     * 
     * @return 
     */
    public List<DTOUsuario> getlUsuario() {
        return lUsuario;
    }
    /**
     * 
     * @param lUsuario 
     */
    public void setlUsuario(List<DTOUsuario> lUsuario) {
        this.lUsuario = lUsuario;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String inicioSesion(){
        DTOUsuario user;
        user = ejbUsuario.login(username, password);
        System.out.println("ENTRA INICIO");
        if(user!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
            return user.getRol().toLowerCase()+"/inicio.xhtml?faces-redirect=true";
        } else {
            System.out.println("SALIO..");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            return "login.xhtml?faces-redirect=true";
        }
                
    }
    
}
