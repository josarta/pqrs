/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.pqrs;

import edu.sena.entity.pqrs.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josar
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public List<Usuario> leerTodo();

    public boolean ingresarUsuario(Usuario usuIn);

    public Usuario inicioSesion(String correoIn, String claveIn);

    public Usuario recuperarClave(String correoIn);

}
