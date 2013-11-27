/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author diego
 */
@Entity
public class Tropa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @Column(name = "identificador")
    private String identificador;
    
    @Basic(optional = false)
    @Column(name = "tipoNegocio")
    private String tipoNegocio;
    @Basic(optional = false)
    @Column(name = "fechaSistema")
    private java.sql.Date fechaSistema;
    @Basic(optional = false)
    @Column(name = "fechaIngreso")
    private java.sql.Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "observaciones")
    private java.sql.Date observaciones;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @ManyToOne(cascade = CascadeType.ALL)
    private Productor propietario;
//    @OneToMany(cascade = CascadeType.ALL)
//    private Animal animales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

   

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Productor getPropietario() {
        return propietario;
    }

    public void setPropietario(Productor propietario) {
        this.propietario = propietario;
    }

    public java.sql.Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(java.sql.Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public java.sql.Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(java.sql.Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    

    public java.sql.Date getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(java.sql.Date observaciones) {
        this.observaciones = observaciones;
    }

//    public Animal getAnimales() {
//        return animales;
//    }
//
//    public void setAnimales(Animal animales) {
//        this.animales = animales;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tropa)) {
            return false;
        }
        Tropa other = (Tropa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Tropa[ id=" + id + " ]";
    }
}
