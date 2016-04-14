/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class MonnaieTest {
    
    Monnaie m1 ;
    Monnaie m2 ;
    Monnaie m3;
    Monnaie instance;
    
    public MonnaieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        m1 = new Monnaie(25, 43);
        m2 = new Monnaie(17, 35);
        instance = new Monnaie(234,56);
    }
    
    @After
    public void tearDown() {
        
        m1 = null;
        m2 = null;
        instance = null;
    }

    /**
     * Test of toString method, of class Monnaie.
     */
    @Test
    public void testToString() {
        
        assertEquals("234.56$", instance.toString());
        assertNotNull(m1.toString());
    }

    /**
     * Test of getDollars method, of class Monnaie.
     */
    @Test
    public void testGetDollars() {
        
        assertEquals(234, instance.getDollars());
        assertEquals(25, m1.getDollars());
    }

    /**
     * Test of getCents method, of class Monnaie.
     */
    @Test
    public void testGetCents() {
        assertEquals(56, instance.getCents());
    }

    /**
     * Test of getTotalCents method, of class Monnaie.
     */
    @Test
    public void testGetTotalCents() {
        
        assertEquals(23456, instance.getTotalCents());
        assertEquals(2543, m1.getTotalCents());
        assertEquals(1735, m2.getTotalCents());
    }

    /**
     * Test of additionner method, of class Monnaie.
     */
    @Test
    public void testAdditionner() {
        m1.additionner(m2);
        assertEquals(4278, m1.getTotalCents());
    }

    /**
     * Test of soustraire method, of class Monnaie.
     * @throws java.lang.Exception
     */
    @Test
    public void testSoustraire() throws Exception {
        
        m1.soustraire(m2);
        assertEquals(808, m1.getTotalCents());
    }

    /**
     * Test of pourcentage method, of class Monnaie.
     */
    @Test
    public void testPourcentage() {
        
        instance.pourcentage(50);
        assertEquals(11728, instance.getTotalCents());
    }

    /**
     * Test of multiplier method, of class Monnaie.
     */
    @Test
    public void testMultiplier() {
        
        m2.multiplier(m1);
        assertEquals(4412105, m2.getTotalCents() );
    }
    
}
