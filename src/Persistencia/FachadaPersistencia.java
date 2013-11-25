/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Presentacion.Mantenimientos;
import dominio.Animal;
import dominio.CambioStock;
import dominio.CategoriaAnimal;
import dominio.Corral;
import dominio.DetalleDieta;
import dominio.Dieta;
import dominio.Insumo;
import dominio.Productor;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.sql.Select;

/**
 *
 * @author diego
 */
public class FachadaPersistencia extends Observable {

    private static FachadaPersistencia instancia = null;

    private FachadaPersistencia() {
    }

    public static FachadaPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new FachadaPersistencia();
        }
        return instancia;
    }
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SiggPU");
    EntityManager em = emf.createEntityManager();

    public List<Object> listar(Object obj) {
        List<Object> lista = null;
        try {

            String object = "";
            if (obj == Corral.class) {
                lista = em.createQuery("select c from Corral c").getResultList();
                object = "corrales";
            } else if (obj == Animal.class) {
                lista = em.createQuery("select a from Animal a").getResultList();
                object = "animales";
            } else if (obj == Productor.class) {
                lista = em.createQuery("select p from Productor p").getResultList();
                object = "productores";
            } else if (obj == Dieta.class) {
                lista = em.createQuery("select dt from Dieta dt").getResultList();
                object = "dietas";
            } else if (obj == Insumo.class) {
                lista = em.createQuery("select i from Insumo i").getResultList();
                object = "insumos";
            }
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(null, "No existen " + object + " para listar.");
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public Object Guardar(Object obj) {
        em.getTransaction().begin();
        setChanged();
        try {
            //merge guarda y  modifica  
            obj = em.merge(obj);
            em.getTransaction().commit();
            if (obj.getClass() != DetalleDieta.class && obj.getClass() != CambioStock.class) {
                JOptionPane.showMessageDialog(null, "La operacion se realizo con éxito.");
            }
        } catch (Exception e) {
            if (obj != DetalleDieta.class && obj.getClass() != CambioStock.class) {
                JOptionPane.showMessageDialog(null, "No se logro guardar los datos ingresados. \n Por Favor verifiquelos.");
            }
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.clear();
        }
        notifyObservers();
        clearChanged();
        return obj;
    }

    public Object buscar(Object o, Object obj) {
        Object object = new Object();
        String aux = (String) obj;
        try {
            if (o == Corral.class) {
                object = em.createQuery("Select c from Corral c where c.nombre=:nom").setParameter("nom", aux).getSingleResult();
            } else if (o == CategoriaAnimal.class) {
                object = em.createQuery("Select c from CategoriaAnimal c where c.nombre=:nom").setParameter("nom", aux).getSingleResult();
            } else if (o == Insumo.class) {
                object = em.createQuery("Select i from Insumo i where i.nombre=:nom").setParameter("nom", aux).getSingleResult();
            } else if (o == Productor.class) {
                object = em.createQuery("Select p from Productor p where p.nombre=:nom").setParameter("nom", aux).getSingleResult();
            } else if (o == Dieta.class) {
                object = em.createQuery("Select d from Dieta d where d.nombre=:nom").setParameter("nom", aux).getSingleResult();
            } else if (o == Animal.class) {
                object = em.createQuery("SELECT a FROM Animal a WHERE a.nroCaravana=:nro").setParameter("nro", Integer.parseInt(aux)).getSingleResult();
            }
        } catch (NoResultException nre) {
            object = null;
        }
        return object;
    }

    public List<Object> listadoHabilitados(Object obj) {
        List<Object> lista = null;
        String object ="";
        if (obj == Productor.class) {
            lista = em.createQuery("select p from Productor p where p.estado='ACTIVO'").getResultList();
            object = "productores";
        } else if (obj == CategoriaAnimal.class) {
            lista = em.createQuery("select c from CategoriaAnimal c where c.estado='ACTIVO'").getResultList();
            object = "categorías de animales";
        } else if (obj == Insumo.class) {
            lista = em.createQuery("select i from Insumo i where i.estado='ACTIVO'").getResultList();
            object = "insumos";
        } else if (obj == Dieta.class) {
            lista = em.createQuery("select d from Dieta d where d.estado='ACTIVO'").getResultList();
            object = "dietas";
        } else if (obj == Corral.class) {
            lista = em.createQuery("select c from Corral c where c.estado='ACTIVO'").getResultList();
            object = "corrales";
        } else if (obj == Animal.class) {
            lista = em.createQuery("select a from Animal a where a.estado='ACTIVO'").getResultList();
            object = "animales";
        }
        if (lista.size() == 0) {
            JOptionPane.showMessageDialog(null, "No existen " + object + " para listar.");
        }
        return lista;
    }

    public Dieta eliminardetalle(Dieta d) {
        em.getTransaction().begin();
        try {
            List<DetalleDieta> lista;
            DetalleDieta detalle;
            lista = em.createQuery("select d from DetalleDieta d where d.dieta= :die").setParameter("die", d.getId()).getResultList();
            for (int i = 0; i < lista.size(); i++) {
                detalle = lista.get(i);
                em.remove(detalle);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.clear();
        }
        return d;
    }

    /*public Dieta eliminarUnDetalle(Dieta d, Insumo ins) {

     em.getTransaction().begin();

     try {
     List<DetalleDieta> lista;
     Object o = new Object();
     Query q=em.createQuery("select d from DetalleDieta d where d.dieta=:die and d.insumo=:ins");
     q.setParameter("die", d.getId());
     q.setParameter("ins", ins.getId());
     o= q.getSingleResult();
     DetalleDieta detalle = (DetalleDieta) o;
     em.remove(detalle);
     em.getTransaction().commit();
     } catch (Exception e) {
     e.printStackTrace();
     if (em.getTransaction().isActive()) {
     em.getTransaction().rollback();
     }
     } finally {
     em.clear();
     }
     return d;
     }*/
    public List<DetalleDieta> listarDetalle(Dieta d) {
        List<DetalleDieta> lista = null;
        lista = em.createQuery("select d from DetalleDieta d where d.dieta=:die").setParameter("die", d.getId()).getResultList();
        return lista;
    }

    public Object buscarId(Object o, Long id) {
        Object obj = new Object();
        if (o == Insumo.class) {
            obj = em.find(Insumo.class, id);
        }
        return obj;
    }

    public void pruebaObserver() {
        setChanged();
        notifyObservers();
        clearChanged();
    }
}
