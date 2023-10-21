/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;


import javax.mail.MessagingException;
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.services.ServiceMateriel;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author megbl
 */
public class Main {
      public static void main(String[] args) throws MessagingException {
        DataSource.getInstance();
        
        Materiel materiel = new Materiel();
    materiel.setIdMat(112); // Remplacez 1 par l'ID du matériel que vous souhaitez modifier
    materiel.setNomMat("Nouveau Nom");
    materiel.setEtatMat("En marche");
    materiel.setQuantiteMat(10);
    
    ServiceMateriel sm =  new ServiceMateriel();

        sm.modifierMateriel(materiel);
    }
        }
    
       


