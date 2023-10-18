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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class FirstPageFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionTerrain(ActionEvent event) {
    try {
        // Chargez le fichier FXML de la vue AfficherTerrain
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherTerrainFXML.fxml"));
        Parent root = loader.load();

        // Créez une nouvelle scène avec la vue AfficherTerrain
        Scene scene = new Scene(root);

        // Obtenez la fenêtre actuelle à partir de l'événement
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Affichez la nouvelle scène dans la fenêtre
        currentStage.setScene(scene);
        currentStage.setTitle("Afficher Terrain"); // Mettez à jour le titre de la fenêtre si nécessaire
        currentStage.show();
    } catch (IOException ex) {
        System.out.println("Erreur lors du chargement de l'interface utilisateur : " + ex.getMessage());
    }
}

    @FXML
    private void gestionActivité(ActionEvent event) {
    try {
        // Chargez le fichier FXML de la vue AfficherActivite
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherActiviteFXML.fxml"));
        Parent root = loader.load();

        // Créez une nouvelle scène avec la vue AfficherActivite
        Scene scene = new Scene(root);

        // Obtenez la fenêtre actuelle à partir de l'événement
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Affichez la nouvelle scène dans la fenêtre
        currentStage.setScene(scene);
        currentStage.setTitle("Afficher Activité"); // Mettez à jour le titre de la fenêtre si nécessaire
        currentStage.show();
    } catch (IOException ex) {
        System.out.println("Erreur lors du chargement de l'interface utilisateur : " + ex.getMessage());
    }
}
    
}
