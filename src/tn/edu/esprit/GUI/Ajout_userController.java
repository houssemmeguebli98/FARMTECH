/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.entities.UserRole;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.tools.DataSource;

/**
 * FXML Controller class
 *
 * @author aladi
 */
public class Ajout_userController implements Initializable {

    @FXML
    private JFXRadioButton agriculteurButton;
    @FXML
    private JFXRadioButton veterinareButton;
    @FXML
    private JFXRadioButton ouvrierButton;
    
    @FXML
    private JFXTextField partNameTextField;
    @FXML
    private JFXTextField partLnvField;
    @FXML
    private JFXTextField partPriceField;
    @FXML
    private JFXTextField villeField;
    @FXML
    private JFXTextField sexeField;
    @FXML
    private JFXTextField passwordField;
    @FXML
    private JFXTextField partCompanyNameField;
    @FXML
    private Label partCompanyNameLabel;
    @FXML
    private JFXTextField NomTextField1;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton cancel;
    @FXML
    private Label password;
    
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void agriculteurButtonAction(ActionEvent event) {
    }

    @FXML
    private void veterinaireButtonAction(ActionEvent event) {
    }
    
    

 @FXML

    private void SaveButtonAction(ActionEvent event) {
        String nom = NomTextField1.getText();
        String prenom = partNameTextField.getText();
        String email = partLnvField.getText();
        String telephone = partPriceField.getText();
        String ville = villeField.getText();
        String sexe = sexeField.getText();
        String password = passwordField.getText();

        // Utilisez l'énumération pour définir le rôle de l'utilisateur
        UserRole role = null;
        if (agriculteurButton.isSelected()) {
            role = UserRole.AGRICULTEUR;
        } else if (ouvrierButton.isSelected()) {
            role = UserRole.OUVRIER;
        } else if (veterinareButton.isSelected()) {
            role = UserRole.VETERINAIRE;
        }

        // Validez les données
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || role == null || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'inscription");
            alert.setHeaderText("Veuillez remplir tous les champs obligatoires.");
            alert.showAndWait();
            return; // Sortez de la méthode car les données sont incorrectes
        }

        // À ce stade, les données sont valides, vous pouvez continuer le processus d'inscription

        Connection con = DataSource.getInstance().getConnection(); // Assurez-vous d'obtenir la connexion correcte

        try {
            String query = "INSERT INTO users (nom, prenom, mail, numeroTelephone, role, motDePasse, ville, sexe) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setString(4, telephone);
            ps.setString(5, role.toString());
            ps.setString(6, password);
            ps.setString(7, ville);
            ps.setString(8, sexe);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) { // L'insertion a réussi
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Inscription réussie");
                successAlert.setHeaderText("Félicitations, votre inscription a été effectuée avec succès.");
                successAlert.showAndWait();

                resetFields(); // Réinitialisez les champs de texte
            } else {
                // L'insertion a échoué
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur d'inscription");
                errorAlert.setHeaderText("Une erreur est survenue lors de l'inscription. Veuillez réessayer.");
                errorAlert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur d'inscription");
            errorAlert.setHeaderText("Une erreur est survenue lors de l'inscription. Veuillez réessayer.");
            errorAlert.showAndWait();
        }
    }

    private void resetFields() {
        // Réinitialisez les champs de texte après une inscription réussie
        NomTextField1.clear();
        partNameTextField.clear();
        partLnvField.clear();
        partPriceField.clear();
        villeField.clear();
        sexeField.clear();
        passwordField.clear();

        // Décochez également les boutons radio si nécessaire
        agriculteurButton.setSelected(false);
        ouvrierButton.setSelected(false);
        veterinareButton.setSelected(false);
    }



    

    @FXML
    private void ouvrierButtonAction(ActionEvent event) {
    }
    
    @FXML
    private void closeButtonAction(ActionEvent event) {
    }
    
}
