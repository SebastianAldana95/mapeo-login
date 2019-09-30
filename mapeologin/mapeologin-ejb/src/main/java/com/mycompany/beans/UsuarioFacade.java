/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brayansebastian
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {
    @PersistenceContext(unitName = "mapeologin_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public DTOUsuario login(String username, String password){
        DTOUsuario user = null;
        Usuario u = null;
        try{
            Query consultaLogin = em.createQuery("FROM Usuario u WHERE u.username = ?1 and u.password = ?2");
            consultaLogin.setParameter(1, username);
            consultaLogin.setParameter(2, password);
            List<Usuario> listUsuario = consultaLogin.getResultList();
            if(!listUsuario.isEmpty()){
                u = listUsuario.get(0);
                user = new DTOUsuario(u.getId(), u.getNombre(), u.getUsername(), u.getPassword(), u.getRol());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return user;
    }
    
    @Override
    public void crearUsuario(DTOUsuario dtoUsuario){
        Usuario user = new Usuario();
        user.setNombre(dtoUsuario.getNombres());
        user.setUsername(dtoUsuario.getUser());
        user.setPassword(dtoUsuario.getPassword());
        user.setRol(dtoUsuario.getRol());
        create(user);    
    }
    
}
