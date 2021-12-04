/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.pqrs;

import edu.sena.entity.pqrs.Rol;
import edu.sena.facade.pqrs.RolFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author josar
 */
@Named(value = "rolSession")
@SessionScoped
public class RolSession implements Serializable {

    @EJB
    RolFacadeLocal rolFacadeLocal;
    private Rol rolTemporal = new Rol();

    /**
     * Creates a new instance of RolSession
     */
    public RolSession() {
    }

    public String cargaRol(Rol rolIn) {
        rolTemporal = rolIn;
        return "editperfiles";
    }

    public String editarRol() {
        try {
            rolFacadeLocal.edit(rolTemporal);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'Actualizado, Exitosamente !!!',"
                    + "  'success'"
                    + ")");
            return "perfiles";
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'No se puede actualizar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
             return "editperfiles";
        }
    }

    public void removerRol(Rol rolIn) {
        try {
            rolFacadeLocal.remove(rolIn);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'Removido, Exitosamente !!!',"
                    + "  'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'No se puede remover, Intente de nuevo',"
                    + "  'error'"
                    + ")");
        }
    }

    public String addRol() {
        try {
            rolFacadeLocal.ingresarRol(rolTemporal);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'Creado, Exitosamente !!!',"
                    + "  'success'"
                    + ")");
            rolTemporal = new Rol();
            return "perfiles";
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Rol',"
                    + "  'No se puede crear, Intente de nuevo',"
                    + "  'error'"
                    + ")");
            rolTemporal = new Rol();
            return "nuevoperfil";
        }
        
    }

    public Rol getRolTemporal() {
        return rolTemporal;
    }

    public void setRolTemporal(Rol rolTemporal) {
        this.rolTemporal = rolTemporal;
    }

}
