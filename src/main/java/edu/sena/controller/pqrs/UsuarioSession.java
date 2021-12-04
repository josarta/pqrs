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
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

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
    private Usuario usuTemporal = new Usuario();
    private Usuario usuLogin = new Usuario();
    private String correIn = "";
    private String claveIn = "";
    private String flag = "";

    /**
     * Creates a new instance of UsuarioSession
     */
    public UsuarioSession() {
    }

    public List<Usuario> leerTodo() {
        return usuarioFacadeLocal.leerTodo();
    }

    public String ingresarUsuario() {
        if (usuarioFacadeLocal.ingresarUsuario(usureg)) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'Creado con Exito !!!',"
                    + "  'success'"
                    + ")");
            usureg = new Usuario();
            return "index";
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'No se puede registrar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
              return "usuarionuevo";

        }
    }

    public void actualizarMisDatos() {
        try {
            usuarioFacadeLocal.edit(usuLogin);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'Actualizado con Exito !!!',"
                    + "  'success'"
                    + ")");

        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'No se pudo actualizar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
        }
    }

    public void cambiarEstado(Usuario usuE) {
        try {
            if (usuE.getUsuEstado().toString().equals("1")) {
                usuE.setUsuEstado(Short.parseShort("0"));
            } else {
                usuE.setUsuEstado(Short.parseShort("1"));
            }
            usuarioFacadeLocal.edit(usuE);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'Actualizado con Exito !!!',"
                    + "  'success'"
                    + ")");

        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'No se pudo actualizar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
        }
    }

    public void cerrarSesion() throws IOException {
        usuLogin = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
        fc.getExternalContext().redirect("../index.xhtml");
    }

    public void validadUsuario() {
        try {
            usuLogin = usuarioFacadeLocal.inicioSesion(correIn, claveIn);
            if (usuLogin != null) {

                if (usuLogin.getUsuEstado().toString().equals("0")) {
                    PrimeFaces.current().executeScript("Swal.fire("
                            + "  'Usuario',"
                            + "  'Bloqueado, Comuniquese con el administrador',"
                            + "  'info'"
                            + ")");
                } else {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.getExternalContext().redirect("usuario/index.xhtml");
                }
            } else {
                PrimeFaces.current().executeScript("Swal.fire("
                        + "  'Usuario',"
                        + "  'No existe en la base de datos, Intente de nuevo',"
                        + "  'error'"
                        + ")");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'Error inesperado, Intente de nuevo',"
                    + "  'error'"
                    + ")");
        }
    }

    public String guardaTemporal(Usuario usuIn){
        usuTemporal = usuIn;
        return "usuarioeditar";
    }
    
     public String actualizarTemporal() {
        try {
            usuarioFacadeLocal.edit(usuTemporal);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'Actualizado con Exito !!!',"
                    + "  'success'"
                    + ")");
            return "index";

        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Usuario',"
                    + "  'No se pudo actualizar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
            return "usuarionuevo";
        }
    }
    
    public List<Rol> leerRoles() {
        return rolFacadeLocal.leerTodo();
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

    public String getCorreIn() {
        return correIn;
    }

    public void setCorreIn(String correIn) {
        this.correIn = correIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

    public Usuario getUsuTemporal() {
        return usuTemporal;
    }

    public void setUsuTemporal(Usuario usuTemporal) {
        this.usuTemporal = usuTemporal;
    }

}
