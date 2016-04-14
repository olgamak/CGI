/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Message.*;
import java.util.*;

/**
 * @author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK Olga
 */
public class Reclamation {

    private String numDossier;
    public String moisReclamation;
    private List<SoinRecu> listeSoinsRecus;

    public Reclamation(String numDossier, String dateReclamation) {

        this.numDossier = numDossier;
        this.moisReclamation = dateReclamation;
        this.listeSoinsRecus = new ArrayList();
    }

    public List<SoinRecu> getListe() {
        return listeSoinsRecus;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public String getMoisReclamation() {
        return moisReclamation;
    }

    public boolean validerDossier(Client client) {

        String str = client.getContrat();
        String dateNaiss = client.getDateNaiss();

        for (int i = 0; i < dateNaiss.length(); i++) {
            if (dateNaiss.charAt(i) != '-') {
                str = str + dateNaiss.charAt(i);
            }
        }
        return str.equals(numDossier);
    }

    public boolean validerMois() {
        return (moisReclamation != null && moisReclamation.substring(0, 7).matches("\\d{4}-(0[1-9]|1[0-2])"));
    }

    public boolean validerLaDateDuSoin(SoinRecu soin) {

        boolean reponse;
        String formatDeLaDate = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
        reponse = comparerDateMois(soin.getDatesoin(), formatDeLaDate, moisReclamation);
        return reponse;
    }

    public boolean comparerDateMois(String date, String formatDeLaDate, String mois) {

        boolean reponse = false;
        if (date != null && date.matches(formatDeLaDate)) {
            //if (validerFormatMois(date.trim().substring(0, 7))) {
            if (validerFormatMois(date.trim().substring(0, 7))) {
                int i = 0;
                while (i < mois.trim().length() && (date.trim().charAt(i) == mois.trim().charAt(i))) {
                    i++;
                }
                reponse = i == mois.trim().length();
            }
        }
        return reponse;
    }

    public boolean validerFormatMois(String mois) {

        return mois != null && mois.substring(0, 7).matches("\\d{4}-(0[1-9]|1[0-2])");
    }

    public static void qualifierLesSoins(Reclamation rec) {

        List<SoinRecu> listeSoins = rec.getListe();

        for (int i = 0; i < listeSoins.size(); i++) {

            SoinRecu unSoin = listeSoins.get(i);
            qualifierLeSoin(unSoin, i + 1, rec);
        }
    }

    public static void qualifierLeSoin(SoinRecu soin, int position, Reclamation rec) {

        qualifierNumSoin(soin, position);
        qualifierdate(soin, position, rec);
        qualifierMontant(soin, position);
        qualifierIdMedecin(soin, position);
    }

    public static void validerReclamation(Reclamation rec, Client client) {

        qualifierMois(rec);
        qualifierDossier(client, rec);
        qualifierLesSoins(rec);
    }
}
