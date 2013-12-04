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
import dominio.CorralAnimal;
import dominio.DetalleDieta;
import dominio.Dieta;
import dominio.Insumo;
import dominio.Productor;
import dominio.Tropa;
import dominio.TropaAnimal;
import java.util.Date;
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
//crear gettransaction aca afuera
    //hacer dos guardar con el mismo nombre solo que uno tenga mas parametros y hace la poarte de transaction
    //el commit lo debe hacer despues que termine la transaction

    public Object Guardar(Object obj, Boolean msj/*Transaction tx*/) {
        //if (tx==null {
        em.getTransaction().begin();
        //tx.gettransaction.begin();
        //}else{
        //tx.gettransaction   usa transaction pasado como parametro
        setChanged();
        try {
            obj = em.merge(obj);
            em.getTransaction().commit();
            //if (obj.getClass() != DetalleDieta.class && obj.getClass() != CambioStock.class && obj.getClass() != CorralAnimal.class) {
            if (msj == true) {
                JOptionPane.showMessageDialog(null, "La operacion se realizo con éxito.");
            }
        } catch (Exception e) {
            //  if (obj != DetalleDieta.class && obj.getClass() != CambioStock.class && obj.getClass() != CorralAnimal.class) {
            if (msj == true) {
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
            } else if (o == Tropa.class) {
                //aca se debe modificar el buscar porque el identificador se puede repetir en distinta fecha
                object = em.createQuery("SELECT t FROM Tropa t WHERE t.identificador=:nro").setParameter("nro", aux).getSingleResult();
            }
        } catch (NoResultException nre) {
            object = null;
        }
        return object;
    }

    public List<Object> listadoHabilitados(Object obj) {
        List<Object> lista = null;
        String object = "";
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

    public Object buscarMayor(Object o) {
        Object object = new Object();
        try {
            if (o == Tropa.class) {
                object = em.createQuery("Select MAX(t.identificador) from Tropa t").getSingleResult();
            }
        } catch (NoResultException nre) {
            object = null;
        }
        return object;
    }

    public List<TropaAnimal> listarAnimales(Tropa t) {
        List<TropaAnimal> lista = null;
        lista = em.createQuery("select ta from TropaAnimal ta where ta.tropa=:tropa").setParameter("tropa", t).getResultList();
        return lista;
    }

    //esta funcio iria en persistencia de animal
    public Corral buscarCorralActual(Animal a) {
        Corral corralActual = new Corral();
        CorralAnimal corral;
        try {
            corral = buscarCorralAnimal(a);
            if (corral != null) {
                corralActual = (Corral) em.createQuery("SELECT c FROM Corral c WHERE c.id=:idCorral").setParameter("idCorral", corral.getCorral().getId()).getSingleResult();
            }
        } catch (NoResultException nre) {
            corralActual = null;
        }
        return corralActual;
    }

    public CorralAnimal buscarCorralAnimal(Animal a) {
        CorralAnimal idCorral = new CorralAnimal();
        try {
            idCorral = (CorralAnimal) em.createQuery("Select c from CorralAnimal c where c.animal=:aux and c.fechaEgr=null").setParameter("aux", a).getSingleResult();
        } catch (NoResultException nre) {
            idCorral = null;
        }
        return idCorral;
    }

    public List<Animal> listarporfecha(Date desde, Date hasta) {
        List<Animal> animales = null;

        animales = (List<Animal>) em.createQuery("SELECT a from Animal a where a.fechaIng>:hasta OR a.fechaEgr<:desde").setParameter(":desde", desde).setParameter(":hasta", hasta);
        return animales;
    }
}
