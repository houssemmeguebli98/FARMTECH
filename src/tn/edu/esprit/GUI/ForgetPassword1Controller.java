/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.UUID;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import tn.edu.esprit.tools.DataSource; // Assurez-vous d'importer correctement votre classe DataSource


/**
 * FXML Controller class
 *
 * @author aladi
 */
public class ForgetPassword1Controller implements Initializable {

    @FXML
    private JFXTextField mailField1;
    @FXML
    private JFXButton envoyerButton;
    @FXML
    private JFXButton annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
private void envoyerAction(ActionEvent event) {
    // Récupérez l'adresse e-mail saisie par l'utilisateur
    String email = mailField1.getText();

    // Vérifiez si l'adresse e-mail existe dans la base de données
    boolean emailExists = doesEmailExist(email);

    if (emailExists) {
        // Générez un code de réinitialisation (une chaîne aléatoire, un jeton unique, etc.)
        String codeDeReinitialisation = generateResetCode(); // Vous devez implémenter cette méthode

        // Enregistrez ce code dans votre base de données ou un autre endroit sécurisé pour une vérification ultérieure
        saveResetCodeInDatabase(email, codeDeReinitialisation); // Vous devez implémenter cette méthode

        // Envoyez le code de réinitialisation par e-mail à l'adresse spécifiée
        sendResetCodeByEmail(email, codeDeReinitialisation); // Vous devez implémenter cette méthode

        // Affichez un message de succès à l'utilisateur
        showInfoMessage("Code de réinitialisation envoyé", "Veuillez consulter votre boîte de réception pour le code de réinitialisation.");

        // Passez à l'écran de réinitialisation du mot de passe (par exemple, en chargeant un nouvel FXML)
        loadPasswordResetScreen(email);
    } else {
        // L'adresse e-mail n'existe pas, affichez une alerte à l'utilisateur
        showErrorMessage("Adresse e-mail introuvable", "L'adresse e-mail saisie n'existe pas dans notre système. Veuillez vérifier votre e-mail.");
    }
}

public boolean doesEmailExist(String email) {
    try {
        Connection connection = DataSource.getInstance().getConnection();
        String query = "SELECT COUNT(*) FROM users WHERE mail = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Si le compte est supérieur à zéro, l'e-mail existe
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // En cas d'erreur ou si l'e-mail n'existe pas
}

public void showInfoMessage(String title, String message) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

public void showErrorMessage(String title, String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}





private void sendResetCodeByEmail(String toEmail, String resetCode) {
    // Configuration de l'envoi de l'e-mail
     Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

    // Adresse e-mail et mot de passe de l'expéditeur
    String fromEmail = "ALABM_FARMTECH@outlook.com"; // Remplacez par votre adresse e-mail
    String fromPassword = "aqwzsxedc2000"; // Remplacez par votre mot de passe

    // Création de la session
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(fromEmail, fromPassword);
        }
    });

    try {
        // Création de l'objet MimeMessage
        MimeMessage message = new MimeMessage(session);

        // Définition de l'expéditeur et du destinataire
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

        // Objet du message
        message.setSubject("Réinitialisation de mot de passe");

        // Contenu du message (dans cet exemple, un simple texte, vous pouvez créer un message HTML)
        message.setText("Votre code de réinitialisation : " + resetCode);

        // Envoi du message
        Transport.send(message);

        System.out.println("E-mail envoyé avec succès.");
    } catch (MessagingException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'envoi de l'e-mail.");
    }
}


public String generateResetCode() {
    return UUID.randomUUID().toString();
}



public void saveResetCodeInDatabase(String email, String resetCode) {
    DataSource dataSource = DataSource.getInstance(); // Obtenez votre connexion à la base de données ici

    Connection conn = dataSource.getConnection(); // Récupérez la connexion depuis votre DataSource

    if (conn != null) {
        String query = "INSERT INTO password_reset (email, reset_code) VALUES (?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, resetCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de la base de données
        }
    }
}


private void loadPasswordResetScreen(String email) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgetPassword2.fxml"));
        Parent root = loader.load();

        // Passez l'e-mail à l'interface "ForgetPassword2Controller" (vous devez ajouter un setter dans cette classe)
        ForgetPassword2Controller controller = loader.getController();
        
         // Appelez la méthode setEmail pour passer l'e-mail
         controller.setEmail(email);
       

        Scene scene = new Scene(root);
        Stage stage = (Stage) envoyerButton.getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace(); // Gérez l'exception correctement en cas d'erreur de chargement de la scène
    }
}



    @FXML
    private void annulerAction(ActionEvent event) {
    }
    
}
