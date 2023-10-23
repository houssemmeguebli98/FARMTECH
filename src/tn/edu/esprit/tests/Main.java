/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import tn.edu.esprit.entities.Ressource;
import tn.edu.esprit.services.ServiceActivite;
import tn.edu.esprit.services.ServiceRessource;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author megbl
 */
public class Main {
      public static void main(String[] args) {
        DataSource.getInstance();
        DataSource.getInstance();
        DataSource.getInstance();
        DataSource.getInstance();
        DataSource.getInstance();
        
        ServiceActivite serviceActivite = new ServiceActivite();
        
    // Activite nouvelleActivite = new Activite();
    //nouvelleActivite.setObjetAct("activité 1");
    //nouvelleActivite.setDescriptionAct("Description activité 1");
    //nouvelleActivite.setDistAct("Distribution activité 1");
    //nouvelleActivite.setEmailDist("hassan@gmail.com");
    //serviceActivite.ajouter(nouvelleActivite);
   
    
    // serviceActivite.supprimer(1);
    
    
    //Activite activiteAModifier = new Activite();
    //activiteAModifier.setIdAct(3); // Remplacez 1 par l'ID de l'activité que vous souhaitez modifier
    //activiteAModifier.setObjetAct("Nouvel objet");
    //activiteAModifier.setDescriptionAct("Nouvelle description");
    //activiteAModifier.setDistAct("Nouvelle distribution");
    //activiteAModifier.setEmailDist("nouveau@email.com");
    //serviceActivite.modifier(activiteAModifier);
    
    }
      
      
      
}
