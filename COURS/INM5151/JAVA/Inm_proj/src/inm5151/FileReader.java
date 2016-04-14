/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;


import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import static inm5151.Message.*;
import java.util.*;
import net.sf.json.JSONArray;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class FileReader {

    public static String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
        
        return IOUtils.toString(new FileInputStream(filePath), fileEncoding);
    }

    public static String chargerFichier(String nomDuFichier) throws IOException {
        
        String texteJson;
        try {
            texteJson = loadFileIntoString(nomDuFichier, "UTF-8");
        } catch (FileNotFoundException e) {
            texteJson = null;
        }
        return texteJson;
    }

    public static JSONObject chargement(String fichierEntree) throws IOException {
        
        String fichier = chargerFichier(fichierEntree);
        validerEtatChargement(fichier);
        JSONObject jObj = formaterFichier(fichier);
        validerEtatFormatage(jObj);
        return jObj;
    }



    public static JSONObject formaterFichier(String texteJson) {
        
        JSONObject objActuel;
        try {
            objActuel = (JSONObject) JSONSerializer.toJSON(texteJson);
        } catch (JSONException e) {
            objActuel = null;
        }
        return objActuel;
    }

    
    
    
    public static List<Police> chargerLesPolice(String fichier) throws IOException{
        
        int compteur = 0;
        List<Police> liste = new ArrayList();
        JSONObject obj = chargement(fichier);
        JSONArray listePolice = (JSONArray) JSONSerializer.toJSON(obj.getString("police"));
        
        for(int i = 0; i < listePolice.size(); i++){
            
            Police pol = new Police(listePolice.getJSONObject(i).getString("contrat"));
            compteur = compteur + 10;
            
            while(i < compteur){
                
                SoinAssure soin = new SoinAssure(listePolice.getJSONObject(i).getString("soin"), listePolice.getJSONObject(i).getDouble("pourcentage"),listePolice.getJSONObject(i).getDouble("limite"));
                pol.getListeSoinsAssures().add(soin);
                i++;
            }
            liste.add(pol);
            i = i-1;
        }
        return liste;
    }
    
}
