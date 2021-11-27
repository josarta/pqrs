/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.pqrs;

import edu.sena.entity.pqrs.Rol;
import edu.sena.entity.pqrs.Usuario;
import edu.sena.facade.pqrs.RolFacadeLocal;
import edu.sena.facade.pqrs.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author josar
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    RolFacadeLocal rolFacadeLocal;
    private Usuario usureg = new Usuario();
    private String flag ="";
    
    
    /**
     * Creates a new instance of UsuarioSession
     */
    public UsuarioSession() {
    }
    
    public List<Usuario> leerTodo(){
       return usuarioFacadeLocal.leerTodo();
    }
    
    public void ingresarUsuario(){
        if(usuarioFacadeLocal.ingresarUsuario(usureg)){
            System.out.println("Usuario Creado");
            flag = "ok";
            usureg = new Usuario();
        }else{
            flag = "error";
            System.out.println("Error Creado usuario");
        }
      
    }
    
    public List<Rol> leerRoles(){
        return  rolFacadeLocal.findAll();
    }

    public Usuario getUsureg() {
        return usureg;
    }

    public void setUsureg(Usuario usureg) {
        this.usureg = usureg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    
}
