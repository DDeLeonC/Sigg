/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class AnimalTest {
    
    public AnimalTest() {
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
     * Test of getId method, of class Animal.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Animal instance = new Animal();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Animal.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Animal instance = new Animal();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNroCaravana method, of class Animal.
     */
    @Test
    public void testGetNroCaravana() {
        System.out.println("getNroCaravana");
        Animal instance = new Animal();
        int expResult = 0;
        int result = instance.getNroCaravana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNroCaravana method, of class Animal.
     */
    @Test
    public void testSetNroCaravana() {
        System.out.println("setNroCaravana");
        int nroCaravana = 0;
        Animal instance = new Animal();
        instance.setNroCaravana(nroCaravana);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPesoActual method, of class Animal.
     */
    @Test
    public void testGetPesoActual() {
        System.out.println("getPesoActual");
        Animal instance = new Animal();
        int expResult = 0;
        int result = instance.getPesoActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPesoActual method, of class Animal.
     */
    @Test
    public void testSetPesoActual() {
        System.out.println("setPesoActual");
        int pesoActual = 0;
        Animal instance = new Animal();
        instance.setPesoActual(pesoActual);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPesoIngreso method, of class Animal.
     */
    @Test
    public void testGetPesoIngreso() {
        System.out.println("getPesoIngreso");
        Animal instance = new Animal();
        int expResult = 0;
        int result = instance.getPesoIngreso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPesoIngreso method, of class Animal.
     */
    @Test
    public void testSetPesoIngreso() {
        System.out.println("setPesoIngreso");
        int pesoIngreso = 0;
        Animal instance = new Animal();
        instance.setPesoIngreso(pesoIngreso);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEstado method, of class Animal.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Animal instance = new Animal();
        instance.setEstado("ACTIVO");
        String expResult = "ACTIVO";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEstado method, of class Animal.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Animal instance = new Animal();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCategoria method, of class Animal.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Animal instance = new Animal();
        CategoriaAnimal expResult = null;
        CategoriaAnimal result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCategoria method, of class Animal.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        CategoriaAnimal categoria = null;
        Animal instance = new Animal();
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProductor method, of class Animal.
     */
    @Test
    public void testGetProductor() {
        System.out.println("getProductor");
        Animal instance = new Animal();
        Productor expResult = null;
        Productor result = instance.getProductor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setProductor method, of class Animal.
     */
    @Test
    public void testSetProductor() {
        System.out.println("setProductor");
        Productor productor = null;
        Animal instance = new Animal();
        instance.setProductor(productor);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class Animal.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Animal instance = new Animal();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class Animal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Animal instance = new Animal();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Animal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Animal instance = new Animal();
        instance.setId(Long.parseLong("1"));
        String expResult = "1";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of persist method, of class Animal.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        Object object = null;
        Animal instance = new Animal();
        instance.persist(object);
        // TODO review the generated test code and remove the default call to fail.
    }
}