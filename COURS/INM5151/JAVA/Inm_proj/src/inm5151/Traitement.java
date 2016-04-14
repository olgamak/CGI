/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import static inm5151.Message.*;

/**
 * @author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK Olga
 */
public class Traitement {

    private static Monnaie remboursement;

    public Traitement() {
        this.remboursement = null;
    }

    public static String getRemboursement() {
        return remboursement.toString();
    }

    public static SoinAssure ExtrairePoliceSoin(Client client, List<Police> lesPolices, SoinRecu unSoin) {

        SoinAssure soinPolice = null;
        boolean trouve = false;
        String contrat = client.getContrat();

        for (int i = 0; i < lesPolices.size() && !trouve; i++) {

            if (contrat.equals(lesPolices.get(i).getContrat())) {

                for (int j = 0; j < lesPolices.get(i).getListeSoinsAssures().size() && !trouve; j++) {

                    if (lesPolices.get(i).getListeSoinsAssures().get(j).getNumSoin().equals(unSoin.getNumSoin())) {
                        soinPolice = lesPolices.get(i).getListeSoinsAssures().get(j);
                        trouve = true;
                    }
                }
            }
        }

        return soinPolice;
    }

    public static void rembourserPolice(String valeur, SoinAssure soinA) {

        double remb;

        DecimalFormat df = formaterEnDecimal();
        String cout = valeur.trim();

        String montant = cout.substring(0, cout.length() - 1);
        int dollar = Integer.parseInt(obtenirPartieEntiere(montant));
        int cent = Integer.parseInt(obtenirPartieDecimale(montant));

        remb = Double.parseDouble(montant.substring(0, montant.length() - 1));

        remboursement = new Monnaie(dollar, cent);

        if (soinA.getLimite() == 0.0) {

            remboursement.pourcentage((int) (soinA.getPourcentage() * 100));

        } else if ((remb * soinA.getPourcentage()) > soinA.getLimite()) {

            String entiere = obtenirPartieEntiere(String.valueOf(soinA.getLimite()));
            String decimale = obtenirPartieDecimale(String.valueOf(soinA.getLimite()));
            remboursement = new Monnaie(Integer.parseInt(entiere), Integer.parseInt(decimale));

        } else if ((remb * soinA.getPourcentage()) < soinA.getLimite()) {
            remboursement.pourcentage((int) soinA.getPourcentage() * 100);
        }

    }

    public static void appliquerPolice(Client client, Reclamation rec, List<Police> lesPolices) {

        String contrat = client.getContrat();
        List<SoinRecu> listeSoin = rec.getListe();

        for (int i = 0; i < listeSoin.size(); i++) {

            SoinRecu soinR = listeSoin.get(i);
            SoinAssure soinA = ExtrairePoliceSoin(client, lesPolices, soinR);
            rembourserPolice(soinR.getMontant(), soinA);
            int position = i + 1;
            afficherRemboursement(listeSoin.get(i), remboursement, position);
        }
    }

    public static DecimalFormat formaterEnDecimal() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", dfs);

        return df;
    }

    public static String obtenirPartieEntiere(String montant) {

        String entier = "";
        int i = 0;

        while (montant.charAt(i) != '.') {
            entier = entier + montant.charAt(i);
            i++;
        }
        return entier.trim();
    }

    public static String obtenirPartieDecimale(String montant) {

        int i = 0;

        while (montant.charAt(i) != '.') {
            i++;
        }
        return montant.substring(i + 1);
    }
}
