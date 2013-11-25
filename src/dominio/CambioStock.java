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
import javax.persistence.Temporal;

/**
 *
 * @author diego
 */
@Entity
public class CambioStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
   @ManyToOne(cascade = CascadeType.ALL)
    private Insumo insumo;
    
    @Basic (optional = false)
    @Column(name = "stockAnterior")
    private int stockAnterior;
    
    @Basic (optional = false)
    @Column(name = "stockPosterior")
    private int stockPosterior;
    
    @Basic (optional = false)
    @Column(name = "observaciones")
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    
    public int getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(int stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public int getStockPosterior() {
        return stockPosterior;
    }

    public void setStockPosterior(int stockPosterior) {
        this.stockPosterior = stockPosterior;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof CambioStock)) {
            return false;
        }
        CambioStock other = (CambioStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CambioStock[ id=" + id + " ]";
    }
    
}
