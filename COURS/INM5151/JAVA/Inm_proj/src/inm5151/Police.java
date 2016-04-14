/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import java.util.*;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Police {
    
    private String contrat;
    private List<SoinAssure> listeSoinsAssures;
    
    public Police(String contrat){
        
        this.listeSoinsAssures = new ArrayList();
        this.contrat = contrat;
    }
    
    public Police(){}
    
    public String getContrat(){
        return contrat;
    }
    
    public List<SoinAssure> getListeSoinsAssures(){
        return listeSoinsAssures;
    }
    
    public void setContrat(String contrat){
        this.contrat = contrat;
    }
    
    public boolean validerContrat() {

        return (contrat != null && contrat.matches("^[ABCDE]$"));
    }
   
    public void ajouterSoinAssure(SoinAssure soin){
    
        listeSoinsAssures.add(soin);
    }
    
    public void supprimerSoinAssure(SoinAssure soin){
    
        listeSoinsAssures.remove(soin);
    }
    
}
