/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Activite;
import tn.edu.esprit.entities.Ressource;
import tn.edu.esprit.services.ServiceActivite;
import tn.edu.esprit.services.ServiceRessource;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AjouterActiviteFXMLController implements Initializable {

    @FXML
    private TextField txtObjetA;
    @FXML
    private TextField txtDistA;
    @FXML
    private TextField txtDescriptionA;
    @FXML
    private TextField txtEmaildistA;
    @FXML
    private CheckBox checkActivite;
    @FXML
    private TextField txtSpecies;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
private void AjouterActivite(ActionEvent event) {
    String objet = txtObjetA.getText();
    String dist = txtDistA.getText();
    String description = txtDescriptionA.getText();
    String emailDist = txtEmaildistA.getText();
    String speciesRES = txtSpecies.getText();

    // Vérification du champ species
    if (speciesRES.isEmpty()) {
        afficherAlerte("Erreur de saisie", "Le champ species ne peut pas être vide.");
    } else if (!validerEmail(emailDist)) {
        afficherAlerte("Erreur de saisie", "L'email n'a pas le format valide (exemple@example.com).");
    } else if (objet.isEmpty() || dist.isEmpty() || description.isEmpty()) {
        afficherAlerte("Erreur de saisie", "Tous les champs sont obligatoires.");
    } else {
        ServiceActivite serviceActivite = new ServiceActivite();
        ServiceRessource serviceRessource = new ServiceRessource();
        // Vérification si l'espèce existe déjà
        Ressource existingActivite = serviceRessource.getOneBySpecies(speciesRES);

        if (existingActivite != null) {
            // Si toutes les vérifications passent, ajoutez l'activité
            Activite activite = new Activite(objet, description, dist, emailDist, speciesRES);
            serviceActivite.ajouter(activite);
            afficherConfirmation("Succès", "L'activité a été ajoutée avec succès.");
            
        } else {
            afficherAlerte("Erreur d'ajout", "L'espèce de ressource n'existe pas.");
        }
    }
}

private boolean validerEmail(String email) {
    // Utilisation d'une expression régulière pour valider le format de l'email
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(regex);
}


private void afficherAlerte(String titre, String contenu) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(titre);
    alert.setHeaderText(null);
    alert.setContentText(contenu);
    alert.showAndWait();
}

private void afficherConfirmation(String titre, String contenu) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(titre);
    alert.setHeaderText(null);
    alert.setContentText(contenu);
    alert.showAndWait();
}

    @FXML
    private void RetourAjoutAct(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherActiviteFXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Obtenez la scène actuelle depuis l'événement
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Affichez la nouvelle scène dans la fenêtre
        stage.setScene(scene);
        stage.setTitle("Afficher Activité"); // Modifiez le titre de la fenêtre si nécessaire
        stage.show();
    } catch (IOException ex) {
        System.out.println("Erreur lors du chargement de l'interface utilisateur : " + ex.getMessage());
    }
}
    
}
