/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author diego
 */
@Entity
public class CorralAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Corral corral;
    @ManyToOne(cascade = CascadeType.ALL)
    private Animal animal;
    @Basic(optional = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fechaIngreso")
    private java.util.Date fechaIng;
    @Basic(optional = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "fechaEgreso")
    private java.util.Date fechaEgr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Corral getCorral() {
        return corral;
    }

    public void setCorral(Corral corral) {
        this.corral = corral;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public java.util.Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(java.util.Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public java.util.Date getFechaEgr() {
        return fechaEgr;
    }

    public void setFechaEgr(java.util.Date fechaEgr) {
        this.fechaEgr = fechaEgr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorralAnimal)) {
            return false;
        }
        CorralAnimal other = (CorralAnimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CorralTropa[ id=" + id + " ]";
    }
}
