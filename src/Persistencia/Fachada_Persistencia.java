/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import dominio.Animal;
import dominio.Corral;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class Fachada_Persistencia {

    private static Fachada_Persistencia instancia = null;

    private Fachada_Persistencia() {
    }

    public static Fachada_Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Fachada_Persistencia();
        }
        return instancia;
    }
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SiggPU");
    EntityManager em = emf.createEntityManager();

    public List<Object> listar(Object obj) {
        List<Object> lista = null;
        if (obj == Corral.class) {
            lista = em.createQuery("select c from Corral c").getResultList();
        } else if (obj == Animal.class) {
            lista = em.createQuery("select a from Animal a").getResultList();
        }
        return lista;
    }
}
