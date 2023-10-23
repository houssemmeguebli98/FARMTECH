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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.UserRole;
import tn.edu.esprit.services.ServiceUser;
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
    @FXML
    private Label fxnotfound;
    
    @FXML
    private Button signup;
    @FXML
    private Hyperlink forgetPassword;
    

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
  

// ...

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

                // Vérifiez si l'utilisateur est un administrateur
                if (UserRole.ADMIN.toString().equals(role)) {
                    // L'utilisateur est un administrateur, ouvrez l'interface Ajout_user
                    openAjoutUserWindow();
                } else {
                    // L'utilisateur n'est pas un administrateur, vous pouvez traiter les autres rôles ici
                }

                // Fermez la fenêtre de connexion actuelle
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            } else {
                // Informez l'utilisateur que l'authentification a échoué
                AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Email ou mot de passe incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Méthode pour ouvrir l'interface Ajout_user
private void openAjoutUserWindow() {
    try {
        // Charger la vue FXML de l'interface Ajout_user
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_interface.fxml"));
        Parent root = loader.load();

        // Créer une nouvelle scène
        Scene scene = new Scene(root);

        // Créer un nouveau stage (fenêtre)
        Stage stage = new Stage();
        stage.setTitle("Ajout d'utilisateur"); // Titre de la nouvelle fenêtre
        stage.setScene(scene);

        // Afficher la nouvelle fenêtre
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}






    @FXML
private void goToSignupAction(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) signup.getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace(); // Gérez l'exception correctement en cas d'erreur de chargement de la scène
    }
}

   @FXML
private void forgotPasswordAction(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgetPassword1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) forgetPassword.getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    
}