/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.util.Iterator;
import java.util.List;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Message;
import tn.edu.esprit.entities.Reclamations;
import tn.edu.esprit.services.MessageService;
import tn.edu.esprit.gui.AjouterMessageController;
import tn.edu.esprit.services.MessageService;
import tn.edu.esprit.services.ReclamationService;
import tn.edu.esprit.tools.DataSource;
/*
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load AjouterMessage.fxml
        Parent ajouterMessageRoot = FXMLLoader.load(getClass().getResource("tn.edu.esprit.gui.AjouterMessage.fxml"));
        Scene ajouterMessageScene = new Scene(ajouterMessageRoot);

        // Load GetAllMessage.fxml
        Parent getAllMessageRoot = FXMLLoader.load(getClass().getResource("tn.edu.esprit.gui.GetAllMessage.fxml"));
        Scene getAllMessageScene = new Scene(getAllMessageRoot);

        // Load ModifierMessage.fxml
        Parent modifierMessageRoot = FXMLLoader.load(getClass().getResource("tn.edu.esprit.gui.ModifierMessage.fxml"));
        Scene modifierMessageScene = new Scene(modifierMessageRoot);

        // Set up the primary stage
        primaryStage.setTitle("FXML Test App");
        primaryStage.setScene(ajouterMessageScene); // Change this to test different FXML files
        primaryStage.show();
    }
*/

public class Main {
    
 
      public static void main(String[] args) throws MessagingException {
        DataSource.getInstance();
        
       
        
        
        
        
        /*
     MessageService messageService = new MessageService();

        // Création d'un objet Message
        Message message = new Message();
        message.setText("Ceci est un message de test.");
        message.setDestinataire("John Doe");
        message.setSource("Jane Doe");
        message.setDate("2023-10-17");

        // Appel de la méthode ajouterMessage
        messageService.ajouterMessage(message);

        System.out.println("Message ajouté avec succès !");   
      
      
       // Création d'une instance de MessageService

        // Appel de la méthode getAll pour récupérer tous les messages
        List<Message> messages = messageService.getAll();

          // Affichage des messages récupérés
          for (Iterator<Message> it = messages.iterator(); it.hasNext();) {
             message = it.next();
              System.out.println("ID: " + message.getId());
              System.out.println("Texte: " + message.getText());
              System.out.println("Destinataire: " + message.getDestinataire());
              System.out.println("Source: " + message.getSource());
              System.out.println("Date: " + message.getDate());
              System.out.println("-----------------------------------");
          }
          Message messageAModifier = new Message();
        messageAModifier.setId(1); // ID du message à modifier (à adapter selon votre cas)
        messageAModifier.setText("Nouveau texte");
        messageAModifier.setDestinataire("Nouveau destinataire");
        messageAModifier.setSource("Nouvelle source");
        messageAModifier.setDate("2023-08-02");

        // Création d'une instance de MessageService

        // Appel de la méthode modifier pour modifier le message
        messageService.modifier(messageAModifier);
      messageService.supprimer(1);
*/
        
        
         ReclamationService service = new ReclamationService();

        // Ajout d'une réclamation
        Reclamations reclamation1 = new Reclamations();
        reclamation1.setType("Problème technique");
        reclamation1.setDescription("Le site a des problèmes de chargement.");
        reclamation1.setEmail("example1@example.com");
        reclamation1.setTelephone("123456789");
        service.ajouterReclamation(reclamation1);

        // Mise à jour du contenu d'une réclamation
        service.updateReclamationContent(1, "Le site a des problèmes de chargement. Veuillez corriger cela rapidement.");

        // Suppression d'une réclamation
        service.supprimerReclamation(2);  // Supposant que l'id 2 correspond à une réclamation existante

        // Récupération de toutes les réclamations
        List<Reclamations> reclamations = service.getAllReclamations();
        for (Reclamations reclamation : reclamations) {
            System.out.println(reclamation);
        }

        // Recherche des réclamations contenant le mot "problème"
        List<Reclamations> matchingReclamations = service.searchReclamations("problème");
        for (Reclamations reclamation : matchingReclamations) {
            System.out.println(reclamation);
            
            
            
     
            
            
            
            
        }
      }
      
      


}















/*


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ajoutermessage.fxml"));
        primaryStage.setTitle("Ajouter Message");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 *
 * @author megbl
 */

/*
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


//}
  //  }
       


