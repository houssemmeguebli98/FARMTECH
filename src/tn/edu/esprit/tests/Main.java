/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import tn.edu.esprit.entities.CategorieMateriel;
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.entities.Parc;
import tn.edu.esprit.services.SendMail;
import tn.edu.esprit.services.ServiceCategorieMateriel;
import tn.edu.esprit.services.ServiceMateriel;
import tn.edu.esprit.services.ServiceParc;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author megbl
 */
public class Main {
      public static void main(String[] args) throws MessagingException {
        DataSource.getInstance();
/*       
        CategorieMateriel categorieMateriel = new CategorieMateriel();
        
categorieMateriel.setNomCatMat("Poid lourds"); 
categorieMateriel.setDescripCatMat("camion ");

    ServiceCategorieMateriel service = new ServiceCategorieMateriel();
   // service.ajouter(categorieMateriel);
    
List<CategorieMateriel> toutesLesCategories = service.getAll();

for (CategorieMateriel categorie : toutesLesCategories) {
    System.out.println("ID : " + categorie.getIdCatMat());
    System.out.println("Nom : " + categorie.getNomCatMat());
    System.out.println("Description : " + categorie.getDescripCatMat());
    System.out.println("-----------------------------");
}



sparc.supprimer(5);
        
parc.setNomParc("Parc de tataouine");
parc.setAdresseParc("Parc de tataouine");
parc.setSuperficieParc(100.2);

sparc.ajouter(parc);
parc.setIdParc(1); 
parc.setNomParc("Nouveau Nomlll");
parc.setAdresseParc("Nouvelle Adresse");
parc.setSuperficieParc(1250.3);

sparc.modifier(parc);
 
ServiceParc sparc = new  ServiceParc();
//Parc parc = new Parc();
List<Parc> tousLesParcs = sparc.getAll();
for (Parc parc : tousLesParcs) {
    System.out.println("ID : " + parc.getIdParc());
    System.out.println("Nom : " + parc.getNomParc());
    System.out.println("Adresse : " + parc.getAdresseParc());
    System.out.println("Superficie : " + parc.getSuperficieParc());
    System.out.println("-----------------------------");
}


    Parc parc = new Parc();
    parc.setIdParc(5); 
    Parc parcRecupere = sparc.getOne(parc);

    if (parcRecupere != null) {
        System.out.println("ID : " + parcRecupere.getIdParc());
        System.out.println("Nom : " + parcRecupere.getNomParc());
        System.out.println("Adresse : " + parcRecupere.getAdresseParc());
        System.out.println("Superficie : " + parcRecupere.getSuperficieParc());
    } else {
        System.out.println("Aucun parc trouvé avec l'ID spécifié.");
    }
}

       // Ajouter un matériel
        Materiel materiel = new Materiel();
        materiel.setNomMat("Ordinateur");
        materiel.setEtatMat(true);
        materiel.setQuantiteMat(10);
        ServiceMateriel service = new ServiceMateriel();
        service.ajouterMateriel(materiel);

        // Récupérer tous les matériels
        List<Materiel> listeMateriels = service.getAllMateriels();
        System.out.println("Liste des matériels :");
        for (Materiel m : listeMateriels) {
            System.out.println(m.getNomMat() + " - Quantité : " + m.getQuantiteMat());
        }

        // Supprimer un matériel
       service.supprimerMateriel(1);
        Materiel materielSupprime = service.getOneMateriel(1);
        if (materielSupprime == null) {
            System.out.println("Le matériel a bien été supprimé.");
        } else {
            System.out.println("Erreur : Le matériel n'a pas été supprimé.");
        }
    }

ServiceMateriel smateriel = new  ServiceMateriel();
Materiel materiel = new Materiel();
materiel.setIdMat(4);
materiel.setNomMat("Nouveau nom materiel");
materiel.setEtatMat(false);
materiel.setQuantiteMat(1250);

smateriel.modifierMateriel(materiel);
 // Récupérer tous les matériels
        List<Materiel> listeMateriels = smateriel.getAllMateriels();
        System.out.println("Liste des matériels :");
        for (Materiel m : listeMateriels) {
            System.out.println(m.getNomMat() + " - Quantité : " + m.getQuantiteMat());
        }
        
       
        
      
Parc parc = new Parc();
        parc.setIdParc(1);
        parc.setNomParc("Parc Test");
        parc.setAdresseParc("123 Rue de l'Informatique");
        parc.setSuperficieParc("100.0");

        SendMail sendMail = new SendMail();

        String destinataire = "megbli.houssam@gmail.com";
        String sujet = "Sujet de l'e-mail";
        String contenu = "Contenu de l'e-mail.";

        try {
            sendMail.envoyerEmail(parc, destinataire, sujet, contenu);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    
      
   
        ServiceMateriel sm = new ServiceMateriel();
        Materiel materiel = sm.getOneMateriel(3);

        if (materiel != null) {
            System.out.println("Materiel trouvé :");
            System.out.println("Nom Parc : " + materiel.getNomParc());
            System.out.println("Nom Matériel : " + materiel.getNomMat());
            System.out.println("Etat Matériel : " + materiel.getEtatMat());
            System.out.println("Quantité Matériel : " + materiel.getQuantiteMat());
            System.out.println("Date d'ajout : " + materiel.getDateAjout());
        } else {
            System.out.println("Aucun matériel trouvé pour l'ID : ");
        }
    
 */  
      //  ServiceMateriel sm = new ServiceMateriel();
       // sm.supprimerMateriel(36);


}
    }
       


