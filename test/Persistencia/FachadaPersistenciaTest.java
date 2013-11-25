/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import dominio.Animal;
import dominio.DetalleDieta;
import dominio.Dieta;
import dominio.Insumo;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class FachadaPersistenciaTest {

    public FachadaPersistenciaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of listar method, of class FachadaPersistencia.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        Object obj = null;
        List expResult = null;
        List result = FachadaPersistencia.getInstancia().listar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Guardar method, of class FachadaPersistencia.
     */
    @Test
    public void testGuardar() {
        System.out.println("Guardar");
        Animal obj;
        Object o = FachadaPersistencia.getInstancia().buscar(Animal.class, Integer.toString(123498765));
        if (o == null) {
            obj = new Animal();
        } else {
            obj = (Animal) o;
        }
        obj.setEstado("ACTIVO");
        obj.setNroCaravana(123498765);
        obj.setPesoIngreso(150);
        obj = (Animal) FachadaPersistencia.getInstancia().Guardar(obj);
        Animal expResult = obj;
        Animal result = (Animal) FachadaPersistencia.getInstancia().buscar(Animal.class, Integer.toString(123498765));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of buscar method, of class FachadaPersistencia.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Animal obj;
        Object o = FachadaPersistencia.getInstancia().buscar(Animal.class, Integer.toString(4321));
        if (o == null) {
            obj = new Animal();
        } else {
            obj = (Animal) o;
        }
        obj.setEstado("ACTIVO");
        obj.setNroCaravana(4321);
        obj.setPesoIngreso(150);
        obj = (Animal) FachadaPersistencia.getInstancia().Guardar(obj);
        Animal expResult = obj;
        Animal result = (Animal) FachadaPersistencia.getInstancia().buscar(Animal.class, Integer.toString(4321));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of eliminardetalle method, of class FachadaPersistencia.
     */
    @Test
    public void testEliminardetalle() {
        System.out.println("eliminardetalle");
        Dieta d = new Dieta();
        List<DetalleDieta> expResult = null;
        List<DetalleDieta> result = FachadaPersistencia.getInstancia().listarDetalle(d);
        if (result.size() == 0) {
            result = null;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    

    /**
     * Test of buscarId method, of class FachadaPersistencia.
     */
    @Test
    public void testBuscarId() {
        System.out.println("buscarId");
        Insumo obj;
        Object o = FachadaPersistencia.getInstancia().buscar(Insumo.class, "Arroz");
        if (o == null) {
            obj = new Insumo();
        } else {
            obj = (Insumo) o;
        }
        obj.setEstado("ACTIVO");
        obj.setNombre("Arroz");
        obj.setHumedad(25);
        obj = (Insumo) FachadaPersistencia.getInstancia().Guardar(obj);
        Insumo expResult = obj;
        Insumo result = (Insumo) FachadaPersistencia.getInstancia().buscarId(Insumo.class, obj.getId());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}