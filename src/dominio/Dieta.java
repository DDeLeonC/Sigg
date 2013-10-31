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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "Dieta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dieta.findAll", query = "SELECT d FROM Dieta d"),
    @NamedQuery(name = "Dieta.findById", query = "SELECT d FROM Dieta d WHERE d.id = :id"),
    @NamedQuery(name = "Dieta.findByNombre", query = "SELECT d FROM Dieta d WHERE d.nombre = :nombre")})
public class Dieta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "costo")
    private Integer costo;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
   /* @ManyToMany
    @JoinTable(
      name="composicion",
      joinColumns={@JoinColumn(name="Id_Dieta", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="Id_Insumo", referencedColumnName="id")})
    @Column (name="cantidad", nullable = false)
    
  private int cantidad;
  */
    
    //compoción es relacion n a n con insumos
    
    public Dieta() {
    }

    public Dieta(Long id) {
        this.id = id;
    }

    public Dieta(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Dieta[ id=" + id + " ]";
    }
    
}
