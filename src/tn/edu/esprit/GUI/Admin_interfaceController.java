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
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author aladi
 */
public class Admin_interfaceController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private TableView<User> UsersTable;

    @FXML
    private TableColumn<?, ?> userID;
    @FXML
    private TableColumn<?, ?> userNom;
    @FXML
    private TableColumn<?, ?> userPrenom;
    @FXML
    private TableColumn<?, ?> userEmail;
    @FXML
    private TableColumn<?, ?> userNumero;
    @FXML
    private TableColumn<?, ?> userRole;
    @FXML
    private TableColumn<?, ?> userVille;
    @FXML
    private TableColumn<?, ?> userSexe;
    @FXML
    private JFXTextField Filter;
    @FXML
    private JFXButton addPartsButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurez vos colonnes du TableView
       userID.setCellValueFactory(new PropertyValueFactory<>("id"));
    userNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    userPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    userEmail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    userNumero.setCellValueFactory(new PropertyValueFactory<>("numeroTelephone"));
    userRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    userVille.setCellValueFactory(new PropertyValueFactory<>("ville"));
    userSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        // Chargez les utilisateurs depuis la base de données et affichez-les
        loadUsers();
    }
     // Méthode pour charger les utilisateurs depuis la base de données
    private void loadUsers() {
        try {
            ServiceUser serviceUser = new ServiceUser();
            List<User> userList = serviceUser.getAll(); // Remplacez cette méthode par celle de votre service

            // Créez une liste observable des utilisateurs pour affichage dans le TableView
            ObservableList<User> userObservableList = FXCollections.observableArrayList(userList);

            // Chargez la liste observable dans le TableView
            UsersTable.setItems(userObservableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void partsSearchButtonAction(ActionEvent event) {
    }

   @FXML
private void partAddButtonAction(ActionEvent event) {
    try {
        // Charger la vue FXML de l'interface Ajout_user
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajout_user.fxml"));
        Parent root = loader.load();

        // Créer une nouvelle scène
        Scene scene = new Scene(root);

        // Obtenir la scène actuelle (à partir du bouton cliqué)
        Stage currentStage = (Stage) addPartsButton.getScene().getWindow();

        // Remplacer la scène actuelle par la nouvelle scène (Ajout_user)
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}



   @FXML
private void partsModifyButtonAction(ActionEvent event) {
    
}


    @FXML
private void deletePartsAction(ActionEvent event) {
    
}

    
}
