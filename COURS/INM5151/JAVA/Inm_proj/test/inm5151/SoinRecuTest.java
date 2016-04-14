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
public class SoinRecuTest {
    
    SoinRecu soin1;
    SoinRecu soin2;
    SoinRecu soin3;
    SoinRecu soin4;
    
    public SoinRecuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        soin1 = new SoinRecu("100", "2016-04-04", "180.00$", "CXS4567");
        soin2 = new SoinRecu("200", "2016-03-04", "230.00$", "DSJ1249");
        soin3 = new SoinRecu();
        soin4 = new SoinRecu("990", "2016-04-04", "16.50$", "KGB1079");
    }
    
    @After
    public void tearDown() {
        
        soin1 = null;
        soin2 = null;
        soin3 = null;
        soin4 = null;
    }

    /**
     * Test of getNumSoin method, of class SoinRecu.
     */
    @Test
    public void testGetNumSoin() {
        
        assertEquals("100", soin1.getNumSoin());
        assertNull(soin3.getNumSoin());
        assertEquals("200", soin2.getNumSoin());
    }

    /**
     * Test of getDatesoin method, of class SoinRecu.
     */
    @Test
    public void testGetDatesoin() {
        
        assertEquals("2016-04-04", soin1.getDatesoin());
        assertNull(soin3.getDatesoin());
        assertEquals("2016-04-04", soin4.getDatesoin());
    }

    /**
     * Test of getMontant method, of class SoinRecu.
     */
    @Test
    public void testGetMontant() {
        
        assertEquals("180.00$", soin1.getMontant());
        assertNull(soin3.getMontant());
        assertEquals("230.00$", soin2.getMontant());
        
        
    }

    /**
     * Test of getIdMedecin method, of class SoinRecu.
     */
    @Test
    public void testGetIdMedecin() {
        
        assertEquals("CXS4567", soin1.getIdMedecin());
        assertNull(soin3.getIdMedecin());
        assertEquals("KGB1079", soin4.getIdMedecin());
    }
    
    @Test
    public void testSetNumSoin() {
        
        assertNull(soin3.getNumSoin());
        soin3.setNumSoin("200");
        assertNotNull(soin3.getNumSoin());
        assertEquals("200", soin3.getNumSoin());
        
    }
    
    @Test
    public void testSetDateSoin() {
        
        assertNull(soin3.getDatesoin());
        soin3.setDateSoin("2016-11-23");
        assertNotNull(soin3.getDatesoin());
        assertEquals("2016-11-23", soin3.getDatesoin());
        
    }
    
    @Test
    public void testSetMontant() {
        
        assertNull(soin3.getMontant());
        soin3.setMontant("234.56$");
        assertNotNull(soin3.getMontant());
        assertEquals("234.56$", soin3.getMontant());
    }
    
    @Test
    public void testSetIdMedecin() {
        
        assertNull(soin3.getIdMedecin());
        soin3.setIdMedecin("DGS7875");
        assertNotNull(soin3.getIdMedecin());
        assertEquals("DGS7875", soin3.getIdMedecin());
    }

    /**
     * Test of validerNumeroSoin method, of class SoinRecu.
     */
    @Test
    public void testValiderNumeroSoin() {
        
        assertTrue(soin1.validerNumeroSoin());
        assertFalse(soin4.validerNumeroSoin());
        assertTrue(soin2.validerNumeroSoin());
    }

    /**
     * Test of validerLaDateDuSoin method, of class SoinRecu.
     */
    @Test
    public void testValiderLaDateDuSoin() {
        
        assertTrue(soin1.validerLaDateDuSoin());
        soin3.setDateSoin("2016-13-18");
        assertFalse(soin3.validerLaDateDuSoin());
        assertTrue(soin2.validerLaDateDuSoin());
    }

    /**
     * Test of validerMontant method, of class SoinRecu.
     */
    @Test
    public void testValiderMontant() {
        
        assertTrue(soin1.validerMontant());
        soin3.setMontant("345.00");
        assertFalse(soin3.validerMontant());
        assertTrue(soin4.validerMontant());
        soin3.setMontant("345$");
        assertTrue(soin3.validerMontant());
    }

    /**
     * Test of validerIdMedecin method, of class SoinRecu.
     */
    @Test
    public void testValiderIdMedecin() {
        
        assertTrue(soin1.validerIdMedecin());
        soin3.setIdMedecin("DRH87");
        assertFalse(soin3.validerLaDateDuSoin());
        assertTrue(soin4.validerMontant());
        soin3.setIdMedecin("D3454");
        assertFalse(soin3.validerMontant());
    }

    /**
     * Test of toString method, of class SoinRecu.
     */
    @Test
    public void testToString() {
        
        String result = soin1.toString();
        assertEquals(result, soin1.toString());
    }
}
