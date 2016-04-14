/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class SoinRecu {
    
    private String dateSoin;
    private String montant;
    private String idMedecin;
    private String numSoin;

    public SoinRecu(String numSoin, String dateSoin, String montant, String idMedecin) {
        
        this.dateSoin = dateSoin;
        this.montant = montant;
        this.idMedecin = idMedecin;
        this.numSoin = numSoin;
    }
    
    public SoinRecu(){}
    
    public String getNumSoin(){
        return numSoin;
    }
    
    public String getDatesoin(){
        return dateSoin;
    }
    
    public String getMontant(){
        return montant;
    }
    
    public String getIdMedecin(){
        return idMedecin;
    }
    
    public void setNumSoin(String numSoin){
        this.numSoin = numSoin;
    }
    
    public void setDateSoin(String dateSoin){
        this.dateSoin = dateSoin;
    }
    
    public void setMontant(String montant){
        this.montant = montant;
    }
    
    public void setIdMedecin(String idMedecin){
        this.idMedecin = idMedecin;
    }
    
    public  boolean validerNumeroSoin(){
        
        return (numSoin.matches("^(0|150|175|[1-7]0{2}|3[0-9]{2})$"));
    }
    
    public boolean validerLaDateDuSoin(){
        
        return (dateSoin != null && dateSoin.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$"));
    }

    public boolean validerMontant(){
        
        return (montant != null && montant.matches("^\\d+[.,]?\\d{2}\\$$"));
    }
    
    public boolean validerIdMedecin() {

        return (idMedecin != null && idMedecin.matches("[A-Z]{3}\\d{4}$"));
    }
    
    @Override
	public String toString() {
		return " [soin = " + numSoin + ", "
                       + "date = " + dateSoin
                       + ", montant = " + montant
                       + ", medecin = " + idMedecin + "]";
	}
}
