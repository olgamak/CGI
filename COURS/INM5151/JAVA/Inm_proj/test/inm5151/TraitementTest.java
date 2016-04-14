/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
public class TraitementTest {

    Client client1;
    Client client2;
    Police police1;
    Police police2;
    Police police3;
    SoinAssure soinAs1;
    SoinAssure soinAs2;
    SoinRecu soinRec1;
    SoinRecu soinRec2;

    List<Police> lesPolices;

    Reclamation recl1;

    public TraitementTest() {
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
        client2 = new Client("Paul", "Dubois", "1980-10-01", "pauldubois@gmail.com", "D");

        police1 = new Police("A");
        police2 = new Police("B");
        police3 = new Police("D");

        lesPolices = new ArrayList();

        lesPolices.add(police1);
        lesPolices.add(police2);

        soinAs1 = new SoinAssure("100", 0.50, 50.0);
        soinAs2 = new SoinAssure("175", 0.9, 80.0);

        soinRec1 = new SoinRecu("100", "2016-04-04", "180.00$", "CXS4567");
        soinRec2 = new SoinRecu("200", "2016-03-04", "230.00$", "DSJ1249");

        police1.ajouterSoinAssure(soinAs1);
        police1.ajouterSoinAssure(soinAs2);

        recl1 = new Reclamation("A19601223", "2016-01-09");
    }

    @After
    public void tearDown() {
        client1 = null;
        client2 = null;
        police1 = null;
        police2 = null;
        police3 = null;
        lesPolices = null;
        recl1 = null;
    }

    /**
     * Test of ExtrairePoliceSoin method, of class Traitement.
     */
    @Test
    public void testExtrairePoliceSoin() {

        assertEquals(soinAs1.getNumSoin(),
                Traitement.ExtrairePoliceSoin(client1, lesPolices, soinRec1).getNumSoin());

    }

    /**
     * Test of rembourserPolice method, of class Traitement.
     */
    @Test
    public void testRembourserPolice() {

        Traitement.rembourserPolice("90.56", soinAs2);
        assertEquals("80.0$", Traitement.getRemboursement());

        Traitement.rembourserPolice("40.88", soinAs1);
        assertEquals("0.0$", Traitement.getRemboursement());
    }

    /**
     * Test of appliquerPolice method, of class Traitement.
     */
    @Test
    public void testAppliquerPolice() {
        /*//System.out.println("appliquerPolice");
         Client client = null;
         Reclamation rec = null;
         List<Police> lesPolices = null;
         Traitement.appliquerPolice(client, rec, lesPolices);
         // TODO review the generated test code and remove the default call to fail.
         fail("The test case is a prototype.");*/

        Traitement.appliquerPolice(client1, recl1, lesPolices);

        //System.out.println("rembours 1: " + Traitement.getRemboursement());
        Traitement.appliquerPolice(client2, recl1, lesPolices);
        //System.out.println("rembours 2: " + Traitement.getRemboursement());

    }

    /**
     * Test of formaterEnDecimal method, of class Traitement.
     */
    @Test
    public void testFormaterEnDecimal() {
        DecimalFormat result = Traitement.formaterEnDecimal();
        assertEquals("#0.00", result.toPattern());
        assertEquals("11.99", result.format(11.99));
    }

    /**
     * Test of obtenirPartieEntiere method, of class Traitement.
     */
    @Test
    public void testObtenirPartieEntiere() {
        String montant = "10.99";
        String expResult = "10";
        String result = Traitement.obtenirPartieEntiere(montant);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenirPartieDecimale method, of class Traitement.
     */
    @Test
    public void testObtenirPartieDecimale() {
        //System.out.println("obtenirPartieDecimale");
        String montant = "10.99";
        String expResult = "99";
        String result = Traitement.obtenirPartieDecimale(montant);
        assertEquals(expResult, result);
    }
}
