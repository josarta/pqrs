/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.pqrs;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author josar
 */
@Entity
@Table(name = "tbl_usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_usuarioid")
    private Integer usuUsuarioid;
    @Size(max = 45)
    @Column(name = "usu_tipodocumento")
    private String usuTipodocumento;
    @Column(name = "usu_documento")
    private BigInteger usuDocumento;
    @Size(max = 60)
    @Column(name = "usu_nombres")
    private String usuNombres;
    @Size(max = 60)
    @Column(name = "usu_apellidos")
    private String usuApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "usu_correoelectronico")
    private String usuCorreoelectronico;
    @Size(max = 45)
    @Column(name = "usu_clave")
    private String usuClave;
    @Column(name = "usu_estado")
    private Short usuEstado;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private Collection<Rol> rolCollection;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Collection<Pqrs> pqrsCollection;
    @OneToMany(mappedBy = "usuario1", fetch = FetchType.LAZY)
    private Collection<Pqrs> pqrsCollection1;
    @OneToMany(mappedBy = "usuario2", fetch = FetchType.LAZY)
    private Collection<Pqrs> pqrsCollection2;

    public Usuario() {
    }

    public Usuario(Integer usuUsuarioid) {
        this.usuUsuarioid = usuUsuarioid;
    }

    public Usuario(Integer usuUsuarioid, String usuCorreoelectronico) {
        this.usuUsuarioid = usuUsuarioid;
        this.usuCorreoelectronico = usuCorreoelectronico;
    }

    public Integer getUsuUsuarioid() {
        return usuUsuarioid;
    }

    public void setUsuUsuarioid(Integer usuUsuarioid) {
        this.usuUsuarioid = usuUsuarioid;
    }

    public String getUsuTipodocumento() {
        return usuTipodocumento;
    }

    public void setUsuTipodocumento(String usuTipodocumento) {
        this.usuTipodocumento = usuTipodocumento;
    }

    public BigInteger getUsuDocumento() {
        return usuDocumento;
    }

    public void setUsuDocumento(BigInteger usuDocumento) {
        this.usuDocumento = usuDocumento;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuCorreoelectronico() {
        return usuCorreoelectronico;
    }

    public void setUsuCorreoelectronico(String usuCorreoelectronico) {
        this.usuCorreoelectronico = usuCorreoelectronico;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Short getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Short usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public Collection<Pqrs> getPqrsCollection() {
        return pqrsCollection;
    }

    public void setPqrsCollection(Collection<Pqrs> pqrsCollection) {
        this.pqrsCollection = pqrsCollection;
    }

    public Collection<Pqrs> getPqrsCollection1() {
        return pqrsCollection1;
    }

    public void setPqrsCollection1(Collection<Pqrs> pqrsCollection1) {
        this.pqrsCollection1 = pqrsCollection1;
    }

    public Collection<Pqrs> getPqrsCollection2() {
        return pqrsCollection2;
    }

    public void setPqrsCollection2(Collection<Pqrs> pqrsCollection2) {
        this.pqrsCollection2 = pqrsCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuUsuarioid != null ? usuUsuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuUsuarioid == null && other.usuUsuarioid != null) || (this.usuUsuarioid != null && !this.usuUsuarioid.equals(other.usuUsuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.pqrs.Usuario[ usuUsuarioid=" + usuUsuarioid + " ]";
    }
    
}
