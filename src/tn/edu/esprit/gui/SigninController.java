/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import helper.AlertHelper;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sun.net.www.http.HttpClient;


import javafx.fxml.FXML;


import java.io.IOException;
import java.net.URI;
import javafx.scene.Node;


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
    
    @FXML
    private Label fxnotfound1;
    
   
    

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
  

// ...

@FXML
private void loginAction() {
    String email = emailField.getText();
    String password = passwordField.getText();

    DataSource dataSource = DataSource.getInstance();
    Connection conn = dataSource.getConnection();

    if (conn != null) {
        // Préparez la requête SQL avec des paramètres pour éviter les injections SQL
        String query = "SELECT * FROM users WHERE mail = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérez le mot de passe haché depuis la base de données
                String hashedPasswordFromDB = resultSet.getString("motDePasse");

                // Utilisez la bibliothèque MessageDigest pour hacher le mot de passe entré
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(password.getBytes());
                byte[] hashedPassword = md.digest();
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashedPassword) {
                    hexString.append(String.format("%02x", b));
                }
                String hashedPasswordString = hexString.toString();

                if (hashedPasswordString.equals(hashedPasswordFromDB)) {
                    // L'authentification a réussi

                    // Vérifiez le rôle de l'utilisateur
                    UserRole userRole = UserRole.valueOf(resultSet.getString("role"));

                    if (userRole == UserRole.ADMIN) {
                        // Redirigez l'administrateur vers l'interface d'administrateur
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_interface.fxml"));
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        // Fermez la fenêtre de connexion actuelle
                        Stage loginStage = (Stage) loginButton.getScene().getWindow();
                        loginStage.close();


                    } else {
                        if (userRole == UserRole.AGRICULTEUR) {
                        // Redirigez l'administrateur vers l'interface d'administrateur
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Agriculteur1.fxml"));
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        // Fermez la fenêtre de connexion actuelle
                        Stage loginStage = (Stage) loginButton.getScene().getWindow();
                        loginStage.close();
                    }
                        else{
                            if (userRole == UserRole.VETERINAIRE) {
                        // Redirigez l'administrateur vers l'interface d'administrateur
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Vet1.fxml"));
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        // Fermez la fenêtre de connexion actuelle
                        Stage loginStage = (Stage) loginButton.getScene().getWindow();
                        loginStage.close();
                    }
                            else{
                                     if (userRole == UserRole.OUVRIER) {
                        // Redirigez l'administrateur vers l'interface d'administrateur
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherOuvrierActiviter.fxml"));
                        
                        Parent root = loader.load();
                   
                     

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        // Fermez la fenêtre de connexion actuelle
                        Stage loginStage = (Stage) loginButton.getScene().getWindow();
                        loginStage.close();
                                   
                                    
                                }
                            
                            }
                            
                        }
                    }
                }else {
                    AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Email ou mot de passe incorrect.");
                }
            } else {
                AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Email ou mot de passe incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Erreur de base de données.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Erreur d'authentification", "Erreur lors du hachage du mot de passe.");
        } catch (IOException e) {
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

public String Getemail() {
    if (emailField != null) {
        String email = emailField.getText();
        return email;
    } else {
        // Gérez le cas où emailField est null (peut-être affichez un message d'erreur ou retournez une valeur par défaut).
        return "Email Field is null";
    }
}

    
}
