/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@Basic(optional = false)
    @Column(name = "observaciones")
    private java.sql.Date observaciones;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @ManyToOne(cascade = CascadeType.ALL)
    private Corral corral;
    @ManyToOne(cascade = CascadeType.ALL)
    private Animal animal;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
