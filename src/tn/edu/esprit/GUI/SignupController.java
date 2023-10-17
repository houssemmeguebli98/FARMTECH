/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.sql.Connection;
import com.gluonhq.charm.glisten.control.TextField;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.entities.UserRole;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.tools.DataSource;


/**
 * FXML Controller class
 *
 * @author aladi
 */
public class SignupController implements Initializable {
    
    private Connection con; // Déclarez la variable con ici

    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Telephome;
    @FXML
    private Button registerButton;
    @FXML
    private RadioButton agriculteurbutton;
    @FXML
    private RadioButton ouvrierbutton;
    @FXML
    private RadioButton veterinairebutton;
    @FXML
    private TextField Sexe;
    @FXML
    private TextField Ville;
    @FXML
    private PasswordField MotDePasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public SignupController() {
           con = DataSource.getInstance().getConnection();
       }    

    @FXML
private void register() {
    // Récupérez les valeurs des champs de texte
    String nom = Nom.getText();
    String prenom = Prenom.getText();
    String email = Email.getText();
    String telephone = Telephome.getText();
    String motDePasse = MotDePasse.getText();

    // Utilisez l'énumération pour définir le rôle de l'utilisateur
    UserRole role = null;
    if (agriculteurbutton.isSelected()) {
        role = UserRole.AGRICULTEUR;
    } else if (ouvrierbutton.isSelected()) {
        role = UserRole.OUVRIER;
    } else if (veterinairebutton.isSelected()) {
        role = UserRole.VETERINAIRE;
    }

    String sexe = Sexe.getText();
    String ville = Ville.getText();

    // Validez les données
    if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || role == null || motDePasse.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur d'inscription");
        alert.setHeaderText("Veuillez remplir tous les champs obligatoires.");
        alert.showAndWait();
        return; // Sortez de la méthode car les données sont incorrectes
    }

    // À ce stade, les données sont valides, vous pouvez continuer le processus d'inscription

    try {
        PreparedStatement ps;
        String query ="INSERT INTO users (nom, prenom, mail, numeroTelephone, role, motDePasse, ville, sexe) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(query);
        ps.setString(1, nom);
        ps.setString(2, prenom);
        ps.setString(3, email);
        ps.setString(4, telephone);
        ps.setString(5, role.toString());
        ps.setString(6, motDePasse);
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
   Nom.setText("");
    Prenom.setText("");
    Email.setText("");
    Telephome.setText("");
    Sexe.setText("");
    Ville.setText("");
    
    MotDePasse.clear();

    // Décochez également les boutons radio si nécessaire
    agriculteurbutton.setSelected(false);
    ouvrierbutton.setSelected(false);
    veterinairebutton.setSelected(false);

    
}


    @FXML
    private void roleAgriculteur(ActionEvent event) {
    }

    @FXML
    private void roleOuvrier(ActionEvent event) {
    }

    @FXML
    private void roleVeterinaire(ActionEvent event) {
    }
    
}
