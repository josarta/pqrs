/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.pqrs;

import edu.sena.entity.pqrs.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josar
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "up_pqrs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public List<Rol> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query qt = em.createQuery("SELECT u FROM Rol u");
        return qt.getResultList();
    }

    @Override
    public boolean ingresarRol(Rol rolIn) {
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_rol(rol_tipo, rol_descripcion, rol_ruta)VALUES (?, ?, ?);");
            qt.setParameter(1, rolIn.getRolTipo());
            qt.setParameter(2, rolIn.getRolDescripcion());
            qt.setParameter(3, rolIn.getRolRuta());
            qt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    
}
