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
public class PoliceTest {
    
    Police police1;
    Police police2;
    Police police3;
    
    public PoliceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        police1 = new Police("A");
        police2 = new Police();
        police3 = new Police("B");
        
    }
    
    @After
    public void tearDown() {
        
        police1 = null;
        police2 = null;
        police3 = null;
    }

    /**
     * Test of getContrat method, of class Police.
     */
    @Test
    public void testGetContrat() {
        
        assertEquals("A",police1.getContrat());
        assertNull(police2.getContrat());
        assertEquals("B", police3.getContrat());
    }

    /**
     * Test of getListeSoinsAssures method, of class Police.
     */
    @Test
    public void testGetListeSoinsAssures() {
        
        assertEquals(0,police1.getListeSoinsAssures().size());
        assertNotNull(police1.getListeSoinsAssures());
    }

    /**
     * Test of setContrat method, of class Police.
     */
    @Test
    public void testSetContrat() {
        
        police2.setContrat("E");
        assertEquals("E", police2.getContrat());
    }

    /**
     * Test of validerContrat method, of class Police.
     */
    @Test
    public void testValiderContrat() {
        
        assertTrue(police1.validerContrat());
        police2.setContrat("T");
        assertFalse(police2.validerContrat());
        assertTrue(police3.validerContrat());
    }

    /**
     * Test of ajouterSoinAssure method, of class Police.
     */
    @Test
    public void testAjouterSoinAssure() {
        
        SoinAssure soin = new SoinAssure("100", 0.50, 50.0);
        police1.ajouterSoinAssure(soin);
        assertFalse(police1.getListeSoinsAssures().isEmpty());
        assertEquals(1,police1.getListeSoinsAssures().size());
    }

    /**
     * Test of supprimerSoinAssure method, of class Police.
     */
    @Test
    public void testSupprimerSoinAssure() {
        
        assertTrue(police1.getListeSoinsAssures().isEmpty());
        SoinAssure soin = new SoinAssure("100", 0.50, 50.0);
        police1.ajouterSoinAssure(soin);
        SoinAssure soin2 = new SoinAssure("175", 0.9, 150.0);
        police1.ajouterSoinAssure(soin2);
        assertEquals(2,police1.getListeSoinsAssures().size());
        police1.supprimerSoinAssure(soin);
        assertEquals(1,police1.getListeSoinsAssures().size());
        police1.supprimerSoinAssure(soin2);
        assertTrue(police1.getListeSoinsAssures().isEmpty());
        
        
    }
    
}
