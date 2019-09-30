/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.ILoginSesion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Brayan Sebastian
 */
@Stateless
public class LoginSesion implements ILoginSesion {

    private List<DTOUsuario> lUsuario;
    private DTOUsuario user1;
    private DTOUsuario user2;

    public LoginSesion() {
        lUsuario = new ArrayList();
    }

    @Override
    public void addUsuarios() {
        user1 = new DTOUsuario("Brayan Sebastian", "brayan", "1111", "administrador");
        user2 = new DTOUsuario("Angie Castaneda", "angie", "1234", "cliente");
        lUsuario.add(user1);
        lUsuario.add(user2);

    }

    @Override
    public DTOUsuario obtainUsuarios(String username, String password) {
        for (DTOUsuario i : lUsuario) {
            if(i.getUser().equals(username) && i.getPassword().equals(password)){
                return i;
            }
        }
        return null;
    }
    
    
}
