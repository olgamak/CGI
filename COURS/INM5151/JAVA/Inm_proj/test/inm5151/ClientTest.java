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
public class ClientTest {
    
    Client client1;
    Client client2;
    Client client3;
    Client client4;
    Client client5;
    Client client6;
    Client client7;
    
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        client1 = new Client("Kent", "Clark", "1960-12-23", "clarkkent@gmail.com", "A");
        client2 = new Client("K", "Clark", "1960-13-23", "clarkkent@gmail.com", "D");
        client3 = new Client("Kone", "C", "1960-12-23", "kone@gmail.com", "E");
        client4 = new Client("Gagnon", "Romain", "1960-12-32", "clarkkent@gmail", "B");
        client5 = new Client("Pelletier", "Albert", "1954-10-10", "albertPel@gmail.com", "Y");
        client6 = new Client();
        client7 = new Client("youssef", "thomas", "1990-09-23", "youlgmail.com", "K");
    }
    
    @After
    public void tearDown() {
        
        client1 = null;
        client2 = null;
        client3 = null;
        client4 = null;
        client5 = null;
        client6 = null;
        client7 = null;
    }

    /**
     * Test of getNom method, of class Client.
     */
    @Test
    public void testGetNom() {
        
        assertEquals("Kent", client1.getNom());
        assertNull(client6.getNom());
        assertEquals("Kone", client3.getNom());
        assertEquals("Pelletier", client5.getNom());
    }

    /**
     * Test of getPrenom method, of class Client.
     */
    @Test
    public void testGetPrenom() {
        
        assertEquals("Clark", client1.getPrenom());
        assertNull(client6.getPrenom());
        assertEquals("Romain", client4.getPrenom());
        assertEquals("Albert", client5.getPrenom());
    }

    /**
     * Test of getDateNaiss method, of class Client.
     */
    @Test
    public void testGetDateNaiss() {
        
        assertEquals("1960-12-23", client1.getDateNaiss());
        assertNull(client6.getDateNaiss());
        assertEquals("1960-12-23", client3.getDateNaiss());
        assertEquals("1954-10-10", client5.getDateNaiss());
        
    }

    /**
     * Test of getCourriel method, of class Client.
     */
    @Test
    public void testGetCourriel() {
        
        assertEquals("clarkkent@gmail.com", client1.getCourriel());
        assertNull(client6.getCourriel());
        assertEquals("kone@gmail.com", client3.getCourriel());
        assertEquals("albertPel@gmail.com", client5.getCourriel());
    }

    /**
     * Test of getContrat method, of class Client.
     */
    @Test
    public void testGetContrat() {
        
        assertEquals("A", client1.getContrat());
        assertNull(client6.getContrat());
        assertEquals("E", client3.getContrat());
        assertEquals("B", client4.getContrat());
    }

    /**
     * Test of setNom method, of class Client.
     */
    @Test
    public void testSetNom() {
        
        client6.setNom("Kalif");
        assertEquals("Kalif", client6.getNom());
    }

    /**
     * Test of setPrenom method, of class Client.
     */
    @Test
    public void testSetPrenom() {
        client6.setPrenom("Renard");
        assertEquals("Renard", client6.getPrenom());
    }

    /**
     * Test of setDateNaiss method, of class Client.
     */
    @Test
    public void testSetDateNaiss() {
        client6.setDateNaiss("1983-03-12");
        assertEquals("1983-03-12", client6.getDateNaiss());
    }

    /**
     * Test of setCourriel method, of class Client.
     */
    @Test
    public void testSetCourriel() {
        
        client6.setCourriel("aligatror5@gmail.com");
        assertEquals("aligatror5@gmail.com", client6.getCourriel());
    }

    /**
     * Test of getContrat method, of class Client.
     */
    @Test
    public void testSetContrat_String() {
        
        client6.setContrat("C");
        assertEquals("C", client6.getContrat());
    }

    /**
     * Test of validerDateNaiss method, of class Client.
     */
    @Test
    public void testValiderDateNaiss() {
        
        assertTrue(client1.validerDateNaiss());
        assertFalse(client4.validerDateNaiss());
        assertFalse(client2.validerDateNaiss());
    }

    /**
     * Test of validerNom method, of class Client.
     */
    @Test
    public void testValiderNom() {
        
        assertTrue(client1.validerNom());
        assertFalse(client2.validerNom());
        assertFalse(client7.validerNom());
        assertTrue(client5.validerNom());
    }

    /**
     * Test of validerPrenom method, of class Client.
     */
    @Test
    public void testValiderPrenom() {
        
        assertTrue(client1.validerPrenom());
        assertFalse(client3.validerPrenom());
        assertFalse(client7.validerPrenom());
        assertTrue(client5.validerPrenom());
    }

    /**
     * Test of validerCourriel method, of class Client.
     */
    @Test
    public void testValiderCourriel() {
        
        assertTrue(client1.validerCourriel());
        assertFalse(client4.validerCourriel());
        assertFalse(client7.validerCourriel());
        assertTrue(client5.validerCourriel());
    }

    /**
     * Test of validerContrat method, of class Client.
     */
    @Test
    public void testValiderContrat() {
        
        assertTrue(client1.validerContrat());
        assertFalse(client5.validerContrat());
        assertFalse(client7.validerContrat());
        assertTrue(client4.validerContrat());
    }

    /**
     * Test of validerClient method, of class Client.
     */
    @Test
    public void testValiderClient() {
        
        assertTrue(client1.validerNom());
        assertTrue(client1.validerPrenom());
        assertTrue(client1.validerCourriel());
        assertTrue(client1.validerContrat());
        assertTrue(client1.validerDateNaiss());
    }
    
}
