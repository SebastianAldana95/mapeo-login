/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOUsuario;
import javax.ejb.Local;

/**
 *
 * @author angie
 */
@Local
public interface ILoginSesion {
    
    public void addUsuarios();
    public DTOUsuario obtainUsuarios(String user, String password);
    
}
