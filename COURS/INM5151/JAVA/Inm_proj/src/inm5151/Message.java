/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static java.lang.System.exit;
import net.sf.json.JSONObject;
/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Message {
    
     public static void validerEtatChargement(String textJson) {
         
        if (Creation.verifierFichier(textJson)) {
            System.out.println("Le fichier n'existe pas.");
            exit(0);
        }
    }

    public static void validerEtatFormatage(JSONObject jsonObj) {
        
        if (Creation.verifierObJson(jsonObj)) {
            System.out.println("Le fichier JSON n'est pas valide.");
            exit(0);
        }
    }

    public static void existenceChampSoin(String champ, String nom, int position) {
        
        if (champ == null) {
            System.out.println("La propriété «"+ nom +"» du soin numéro " + position + " est manquante.");
            exit(0);
        }
    }

    public static void existenceChamp(String champ, String nom) {
        
        if (champ == null) {
            if(nom.equals("mois") || nom.equals("dossier") || nom.equals("reclamations"))
                System.out.println("L'attribut «"+ nom +"» de la réclamation est manquant");
            else
                System.out.println("L'attribut «"+ nom +"» du client est manquant");
            exit(0);
        }
    }

    public static void qualifierNom(Client client) {
        
        if (!(client.validerNom())) {
            System.out.println("Le nom du client n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierPrenom(Client client) {
        
        if (!(client.validerPrenom())) {
            System.out.println("Le prénom du client n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierDateNaiss(Client client) {
        
        if (!(client.validerDateNaiss())) {
            System.out.println("La date de naissance du client n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierCourriel(Client client) {
        
        if (!(client.validerCourriel())) {
            System.out.println("L'adresse courriel du client n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierContrat(Client client) {
        
        if (!(client.validerContrat())) {
            System.out.println("Le contrat du client n'est pas valide.");
            exit(0);
        }
    }
    
    
    
    public static void qualifierMois(Reclamation reclam) {
        
        if (!(reclam.validerMois())) {
            System.out.println("Le mois de la réclamation n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierDossier(Client client,Reclamation reclam) {
        
        if (!(reclam.validerDossier(client))) {
            System.out.println("Le numéro de dossier du client n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierNumSoin(SoinRecu soin, int position) {
        
        if (!(soin.validerNumeroSoin())) {
            System.out.println("Le numéro du soin " + position + " n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierdate(SoinRecu soin, int position, Reclamation rec) {
        
        if (!(rec.validerLaDateDuSoin(soin))) {
            System.out.println("La date du soin " + position + " n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierMontant(SoinRecu soin, int position) {
        
        if (!(soin.validerMontant())) {
            System.out.println("Le montant du soin " + position + " n'est pas valide.");
            exit(0);
        }
    }
    
    public static void qualifierIdMedecin(SoinRecu soin, int position) {
        
        if (!(soin.validerIdMedecin())) {
            System.out.println("L'identifiant du médecin du soin " + position + " n'est pas valide.");
            exit(0);
        }
    }
    
    public static void afficherRemboursement(SoinRecu soin, Monnaie remboursement,int position){
        
        System.out.println(" Soin "+position+" : ");
        System.out.println(soin);
        System.out.println(" Remboursement : "+remboursement);
        System.out.println("======================================================================");
    }
}
