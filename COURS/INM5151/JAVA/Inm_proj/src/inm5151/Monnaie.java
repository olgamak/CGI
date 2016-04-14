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
public class Monnaie {
    
    private int totalCents = 0;
    
    public Monnaie (int dollars, int cents)throws IllegalArgumentException  {
        
       if(dollars < 0 || cents < 0 || cents > 99){
           throw new IllegalArgumentException();
       }else{
           totalCents = dollars * 100 + cents;
       }
    }
    
    @Override
    public String toString(){
        
        return getDollars() + "." + getCents() + "$";
    }
    
    public int getDollars (){
        
        return this.totalCents / 100;
    }
    
    public int getCents(){
        
        return this.totalCents % 100;
    }
    
    public int getTotalCents(){
        
        return this.totalCents;
    }
    
    public void additionner (Monnaie autre){
        
        this.totalCents += autre.totalCents;
    }
    
    public void soustraire (Monnaie autre) throws OperationInvalideException {
        
        verifierOperandes(autre);
        this.totalCents -= autre.totalCents;
    }
    
    public void pourcentage(int taux){
        
        int valeur = this.totalCents * taux;
        totalCents = (valeur / 100) + (valeur % 100);
    }
    
    public void multiplier (Monnaie autre){
        
        this.totalCents = this.totalCents * autre.totalCents;
    }
    
    private void verifierOperandes(Monnaie autre) throws OperationInvalideException {
        
	if ( this.totalCents < autre.getTotalCents()) {
            
            throw new OperationInvalideException("Opération impossible : "
		+ this.totalCents + " - " + autre.totalCents);
	}
    }
}
    