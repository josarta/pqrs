/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.pqrs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author josar
 */
@Entity
@Table(name = "tbl_pqrs")
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pqr_pqrsid")
    private Integer pqrPqrsid;
    @Column(name = "pqu_fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pquFechacreacion;
    @Column(name = "pqu_fechaasignacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pquFechaasignacion;
    @Column(name = "pqu_fecharespuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pquFecharespuesta;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pqu_solicitud")
    private String pquSolicitud;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pqu_respuesta")
    private String pquRespuesta;
    @Size(max = 45)
    @Column(name = "pqu_estado")
    private String pquEstado;
    @JoinColumns({
        @JoinColumn(name = "fk_usucrea", referencedColumnName = "usu_usuarioid"),
        @JoinColumn(name = "fk_usucrea", referencedColumnName = "usu_usuarioid")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumns({
        @JoinColumn(name = "fk_usuasigna", referencedColumnName = "usu_usuarioid"),
        @JoinColumn(name = "fk_usuasigna", referencedColumnName = "usu_usuarioid")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario1;
    @JoinColumns({
        @JoinColumn(name = "fk_usuresponde", referencedColumnName = "usu_usuarioid"),
        @JoinColumn(name = "fk_usuresponde", referencedColumnName = "usu_usuarioid")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario2;

    public Pqrs() {
    }

    public Pqrs(Integer pqrPqrsid) {
        this.pqrPqrsid = pqrPqrsid;
    }

    public Integer getPqrPqrsid() {
        return pqrPqrsid;
    }

    public void setPqrPqrsid(Integer pqrPqrsid) {
        this.pqrPqrsid = pqrPqrsid;
    }

    public Date getPquFechacreacion() {
        return pquFechacreacion;
    }

    public void setPquFechacreacion(Date pquFechacreacion) {
        this.pquFechacreacion = pquFechacreacion;
    }

    public Date getPquFechaasignacion() {
        return pquFechaasignacion;
    }

    public void setPquFechaasignacion(Date pquFechaasignacion) {
        this.pquFechaasignacion = pquFechaasignacion;
    }

    public Date getPquFecharespuesta() {
        return pquFecharespuesta;
    }

    public void setPquFecharespuesta(Date pquFecharespuesta) {
        this.pquFecharespuesta = pquFecharespuesta;
    }

    public String getPquSolicitud() {
        return pquSolicitud;
    }

    public void setPquSolicitud(String pquSolicitud) {
        this.pquSolicitud = pquSolicitud;
    }

    public String getPquRespuesta() {
        return pquRespuesta;
    }

    public void setPquRespuesta(String pquRespuesta) {
        this.pquRespuesta = pquRespuesta;
    }

    public String getPquEstado() {
        return pquEstado;
    }

    public void setPquEstado(String pquEstado) {
        this.pquEstado = pquEstado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pqrPqrsid != null ? pqrPqrsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.pqrPqrsid == null && other.pqrPqrsid != null) || (this.pqrPqrsid != null && !this.pqrPqrsid.equals(other.pqrPqrsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.pqrs.Pqrs[ pqrPqrsid=" + pqrPqrsid + " ]";
    }
    
}
