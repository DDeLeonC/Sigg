/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Observable;
import javax.swing.JPanel;
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
public class MantenimientosTest {
    
    public MantenimientosTest() {
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
     * Test of guardar method, of class Mantenimientos.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Object object = null;
        Object expResult = null;
        Object result = Mantenimientos.guardar(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class Mantenimientos.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object o = null;
        String str = "";
        Object expResult = null;
        Object result = Mantenimientos.buscar(o, str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Mantenimientos.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = null;
        Object o1 = null;
        Mantenimientos instance = new Mantenimientos();
        instance.update(o, o1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarCampos method, of class Mantenimientos.
     */
    @Test
    public void testLimpiarCampos() {
        System.out.println("limpiarCampos");
        JPanel jPanel = null;
        Mantenimientos instance = new Mantenimientos();
        instance.limpiarCampos(jPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}