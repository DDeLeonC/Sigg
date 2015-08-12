/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
/*hola estas?*/
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author diego
 */
@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @Column(name = "nroCaravana")
    private int nroCaravana;
    @Basic(optional = false)
    @Column(name = "pesoActual")
    private int pesoActual;
    @Basic(optional = false)
    @Column(name = "pesoIngreso")
    private int pesoIngreso;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoriaAnimal categoria;
    @ManyToOne(cascade = CascadeType.ALL)
    private Productor productor;
    @Basic(optional = false)
    @Column(name = "fechaIng")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIng;
    @Basic(optional = true)
    @Column(name = "fechaEgr")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEgr;
    //pesadas es relación

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaEgr() {
        return fechaEgr;
    }

    public void setFechaEgr(Date fechaEgr) {
        this.fechaEgr = fechaEgr;
    }

    public int getNroCaravana() {
        return nroCaravana;
    }

    public void setNroCaravana(int nroCaravana) {
        this.nroCaravana = nroCaravana;
    }

    public int getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(int pesoActual) {
        this.pesoActual = pesoActual;
    }

    public int getPesoIngreso() {
        return pesoIngreso;
    }

    public void setPesoIngreso(int pesoIngreso) {
        this.pesoIngreso = pesoIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CategoriaAnimal getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAnimal categoria) {
        this.categoria = categoria;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SiggPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
