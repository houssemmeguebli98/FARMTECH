/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import helper.AlertHelper;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import tn.edu.esprit.tools.DataSource;

/**
 * FXML Controller class
 *
 * @author aladi
 */
public class SigninController implements Initializable {
    @FXML
    private com.gluonhq.charm.glisten.control.TextField emailField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;
    


    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   @FXML
    private void loginAction() {
    String email = emailField.getText();
    String password = passwordField.getText();

    // Utilisez la classe DataSource pour obtenir une connexion à la base de données
    DataSource dataSource = DataSource.getInstance();
    Connection conn = dataSource.getConnection();

    if (conn != null) {
        // Préparez la requête SQL pour vérifier les informations d'authentification
        String query = "SELECT * FROM users WHERE mail = ? AND motDePasse = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Authentification réussie
                String role = resultSet.getString("role");
                // Vous pouvez traiter le rôle de l'utilisateur ici

                // Fermez la fenêtre de connexion actuelle
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                // Ouvrez la nouvelle fenêtre ou effectuez d'autres actions appropriées
                //openMainApplicationWindow(role);
            } else {
                // Informez l'utilisateur que l'authentification a échoué
                AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    @FXML
private void goToSignup() {
    try {
        // Charger la vue FXML de la page d'inscription
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent root = loader.load();

        // Créer une nouvelle scène
        Scene scene = new Scene(root);

        // Créer un nouveau stage (fenêtre)
        Stage stage = new Stage();
        stage.setTitle("Inscription"); // Titre de la nouvelle fenêtre
        stage.setScene(scene);

        // Afficher la nouvelle fenêtre
        stage.show();

        // Fermer la fenêtre actuelle (fenêtre de connexion)
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    @FXML
    private void forgotPassword() {
        // Ajoutez la logique de récupération de mot de passe ici.
    }
    
}
