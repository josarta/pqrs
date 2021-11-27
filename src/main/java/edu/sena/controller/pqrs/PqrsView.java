/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.pqrs;

import edu.sena.entity.pqrs.Pqrs;
import edu.sena.facade.pqrs.PqrsFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author josar
 */
@Named(value = "pqrsView")
@ViewScoped
public class PqrsView implements Serializable{
    @EJB
    PqrsFacadeLocal pqrsFacadeLocal;

    /**
     * Creates a new instance of PqrsView
     */
    public PqrsView() {
    }
    
    public List<Pqrs> leerTodos(){
        return pqrsFacadeLocal.findAll();
    }
    
}
