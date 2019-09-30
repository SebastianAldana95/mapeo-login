/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author brayansebastian
 */
@Named(value = "pageErrorController")
@RequestScoped
public class PageErrorController {

    /**
     * Creates a new instance of PageErrorController
     */
    public PageErrorController() {
    }
    
    private String msj;

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    
    public String navigate(){
        System.out.println(10 / 0);
        return "login";
    }
    
}
