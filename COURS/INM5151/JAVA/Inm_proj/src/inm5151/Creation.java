/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Client.*;
import static inm5151.Message.*;
import static inm5151.FileReader.*;
import static inm5151.Reclamation.validerReclamation;
import static inm5151.Traitement.appliquerPolice;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Creation {

    public static Client creerReclamant(JSONObject jObj) {
        String nom = extraireChamp(jObj, "nom");
        existenceChamp(nom, "nom");
        String prenom = extraireChamp(jObj, "prenom");
        existenceChamp(prenom, "prenom");
        String dateNaiss = extraireChamp(jObj, "dateNaiss");
        existenceChamp(dateNaiss, "dateNaiss");
        String mois = extraireChamp(jObj, "mois");
        existenceChamp(mois, "mois");
        String courriel = extraireChamp(jObj, "courriel");
        existenceChamp(courriel, "courriel");
        String contrat = extraireChamp(jObj, "contrat");
        existenceChamp(contrat, "contrat");
        String dossier = extraireChamp(jObj, "dossier");
        existenceChamp(dossier, "dossier");
        String reclam = extraireChamp(jObj, "reclamations");
        existenceChamp(reclam, "reclamations");
        Client client = new Client(nom, prenom, dateNaiss, courriel, contrat);
        return client;
    }

    public static void ajouterSoin(Reclamation reclam, SoinRecu soin) {
        reclam.getListe().add(soin);
    }

    public static void traiterDemande(String fichierEntree, String FichierPolice) throws IOException {
        
        List<Police> listePolice;
        JSONObject obj = chargement(fichierEntree);
        Client client = creerReclamant(obj);
        validerClient(client);
        Reclamation rec = creerReclamation(obj);
        validerReclamation(rec, client);
        listePolice = chargerLesPolice(FichierPolice);
        appliquerPolice(client, rec, listePolice);
    }

    public static SoinRecu creerSoin(JSONObject objetSoin) {
        
        String numSoin = objetSoin.getString("soin");
        String dateSoin = objetSoin.getString("date");
        String montant = objetSoin.getString("montant");
        String idMedecin = objetSoin.getString("medecin");
        SoinRecu unSoin = new SoinRecu(numSoin, dateSoin, montant, idMedecin);
        return unSoin;
    }

    public static String extraireChamp(JSONObject objet, String champ) {
        
        String resultat;
        try {
            resultat = objet.getString(champ);
        } catch (JSONException e) {
            resultat = null;
        }
        return resultat;
    }

    public static Reclamation creerReclamation(JSONObject obj) {
        
        String reclamation = obj.getString("reclamations");
        JSONArray listeSoins = (JSONArray) JSONSerializer.toJSON(reclamation);
        verifierFormatDesSoins(listeSoins);
        Reclamation reclam = new Reclamation(obj.getString("dossier"), obj.getString("mois"));
        
        for (int i = 0; i < listeSoins.size(); i++) {
            JSONObject objetSoin = listeSoins.getJSONObject(i);
            SoinRecu unSoin = creerSoin(objetSoin);
            ajouterSoin(reclam, unSoin);
        }
        return reclam;
    }

    public static boolean verifierFichier(String textJson) {
        return textJson == null;
    }

    public static boolean verifierObJson(JSONObject jsonObj) {
        return jsonObj == null;
    }

    public static void verifierFormatDesSoins(JSONArray listeSoins) {
        for (int i = 0; i < listeSoins.size(); i++) {
            JSONObject objetSoin = listeSoins.getJSONObject(i);
            String numSoin = Creation.extraireChamp(objetSoin, "soin");
            existenceChampSoin(numSoin, "soin", i + 1);
            String date = Creation.extraireChamp(objetSoin, "date");
            existenceChampSoin(date, "date", i + 1);
            String montant = Creation.extraireChamp(objetSoin, "montant");
            existenceChampSoin(montant, "montant", i + 1);
            String med = Creation.extraireChamp(objetSoin, "medecin");
            existenceChampSoin(med, "medecin", i + 1);
        }
    }
}
