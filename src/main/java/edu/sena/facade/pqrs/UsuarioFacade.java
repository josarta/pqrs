/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.pqrs;

import edu.sena.entity.pqrs.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "up_pqrs")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query qt = em.createQuery("SELECT u FROM Usuario u");
        return qt.getResultList();
    }

    @Override
    public boolean ingresarUsuario(Usuario usuIn) {
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_usuario (usu_tipodocumento,usu_documento,usu_nombres,usu_apellidos,usu_correoelectronico, usu_clave) VALUES (?,?,?,?,?,?);");
            qt.setParameter(1, usuIn.getUsuTipodocumento());
            qt.setParameter(2, usuIn.getUsuDocumento());
            qt.setParameter(3, usuIn.getUsuNombres());
            qt.setParameter(4, usuIn.getUsuApellidos());
            qt.setParameter(5, usuIn.getUsuCorreoelectronico());
            qt.setParameter(6, usuIn.getUsuClave());
            qt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario inicioSesion(String correoIn, String claveIn) {
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuCorreoelectronico = :correoIn AND u.usuClave = :claveIn");
            q.setParameter("correoIn", correoIn);
            q.setParameter("claveIn", claveIn);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario recuperarClave(String correoIn) {
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuCorreoelectronico = :correoIn");
            q.setParameter("correoIn", correoIn);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
