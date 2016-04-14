/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import java.io.IOException;
import static inm5151.Creation.*;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class ProgrammPrincipal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2){
            System.out.println("Le chemin du fichier manque...");
        }else { 
            traiterDemande(args[0], args[1]);
        } 
    }
}
       