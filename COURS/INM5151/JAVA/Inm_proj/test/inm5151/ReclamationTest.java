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
 * @author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK Olga
 */
public class ReclamationTest {

    Reclamation recl1;
    Reclamation recl2;
    Reclamation recl3;
    Reclamation recl4;

    Client client1;
    Client client2;

    SoinRecu soin1;
    SoinRecu soin2;
    SoinRecu soin3;

    public ReclamationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        recl1 = new Reclamation("A19601223", "2016-01-09"); //client1
        recl2 = new Reclamation("A19601223", "2015-02-14");//client1
        recl3 = new Reclamation("D19801001", "2014-03-23");//client2
        recl4 = new Reclamation("D19801001", "2014-13-23");

        client1 = new Client("Kent", "Clark", "1960-12-23", "clarkkent@gmail.com", "A");
        client2 = new Client("K", "Clark", "1980-10-01", "clarkkent@gmail.com", "D");

        soin1 = new SoinRecu("100", "2016-01-09", "180.00$", "CXS4567");
        soin2 = new SoinRecu("200", "2016-01-09", "230.00$", "DSJ1249");
        soin3 = new SoinRecu("990", "2016-04-04", "16.50$", "KGB1079");

        recl1.getListe().add(soin1);
        recl1.getListe().add(soin2);
    }

    @After
    public void tearDown() {
        recl1 = null;
        recl2 = null;
        recl3 = null;
        client1 = null;
        client2 = null;
        soin1 = null;
        soin2 = null;
        soin3 = null;

    }

    /**
     * Test of getListe method, of class Reclamation.
     */
    @Test
    public void testGetListe() {
        assertEquals(2, recl1.getListe().size());
        assertNotNull(recl1.getListe());
    }

    /**
     * Test of getNumDossier method, of class Reclamation.
     */
    @Test
    public void testGetNumDossier() {
        assertEquals("A19601223", recl1.getNumDossier());
        assertEquals("A19601223", recl2.getNumDossier());
        assertEquals("D19801001", recl3.getNumDossier());
    }

    /**
     * Test of getMoisReclamation method, of class Reclamation.
     */
    @Test
    public void testGetMoisReclamation() {
        assertEquals("2016-01-09", recl1.getMoisReclamation());
        assertEquals("2015-02-14", recl2.getMoisReclamation());
        assertEquals("2014-03-23", recl3.getMoisReclamation());
    }

    /**
     * Test of validerDossier method, of class Reclamation.
     */
    @Test
    public void testValiderDossier() {
        assertTrue(recl1.validerDossier(client1));
        assertTrue(recl2.validerDossier(client1));
        assertTrue(recl3.validerDossier(client2));
        assertFalse(recl1.validerDossier(client2));
    }

    /**
     * Test of validerMois method, of class Reclamation.
     */
    @Test
    public void testValiderMois() {
        assertTrue(recl1.validerMois());
        assertTrue(recl2.validerMois());
        assertTrue(recl3.validerMois());
    }

    /**
     * Test of validerLaDateDuSoin method, of class Reclamation.
     */
    @Test
    public void testValiderLaDateDuSoin() {
        assertTrue(recl1.validerLaDateDuSoin(recl1.getListe().get(0)));
        assertTrue(recl1.validerLaDateDuSoin(recl1.getListe().get(1)));

    }

    /**
     * Test of comparerDateMois method, of class Reclamation.
     */
    @Test
    public void testComparerDateMois() {
        assertTrue(recl1.comparerDateMois("2016-01-09", "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", recl1.getMoisReclamation()));
        assertTrue(recl2.comparerDateMois("2015-02-14", "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", recl2.getMoisReclamation()));
        assertFalse(recl3.comparerDateMois("2010-01-09", "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", recl3.getMoisReclamation()));
    }

    /**
     * Test of validerFormatMois method, of class Reclamation.
     */
    @Test
    public void testValiderFormatMois() {
        assertEquals(true, recl1.validerFormatMois(recl1.getMoisReclamation()));
        assertEquals(true, recl2.validerFormatMois(recl2.getMoisReclamation()));
        assertEquals(false, recl4.validerFormatMois(recl4.getMoisReclamation()));

    }

    /**
     * Test of qualifierLesSoins method, of class Reclamation.
     */
    @Test
    public void testQualifierLesSoins() {
        for (int i = 0; i < recl1.getListe().size(); i++) {

            assertTrue(recl1.getListe().get(i).validerNumeroSoin());
            assertTrue(recl1.getListe().get(i).validerLaDateDuSoin());
            assertTrue(recl1.getListe().get(i).validerMontant());
            assertTrue(recl1.getListe().get(i).validerIdMedecin());

        }

    }

    /**
     * Test of qualifierLeSoin method, of class Reclamation.
     */
    @Test
    public void testQualifierLeSoin() {
        assertTrue(soin1.validerNumeroSoin());
        assertTrue(soin1.validerLaDateDuSoin());
        assertTrue(soin1.validerMontant());
        assertTrue(soin1.validerIdMedecin());

        assertTrue(soin2.validerNumeroSoin());
        assertTrue(soin2.validerLaDateDuSoin());
        assertTrue(soin2.validerMontant());
        assertTrue(soin2.validerIdMedecin());

    }

    /**
     * Test of validerReclamation method, of class Reclamation.
     */
    @Test
    public void testValiderReclamation() {
        assertTrue(recl1.validerMois());
        assertTrue(recl1.validerDossier(client1));
        for (int i = 0; i < recl1.getListe().size(); i++) {

            assertTrue(recl1.getListe().get(i).validerNumeroSoin());
            assertTrue(recl1.getListe().get(i).validerLaDateDuSoin());
            assertTrue(recl1.getListe().get(i).validerMontant());
            assertTrue(recl1.getListe().get(i).validerIdMedecin());
        }

    }

}
