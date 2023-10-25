/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

<<<<<<< HEAD
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
=======
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
<<<<<<< HEAD
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
=======
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
<<<<<<< HEAD
import javafx.stage.Stage;
=======
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
import tn.edu.esprit.entities.Activite;
import tn.edu.esprit.services.ServiceActivite;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AfficherOuvrierActiviterController implements Initializable {

    @FXML
    private TableColumn<Activite, String> objetA;
    @FXML
    private TableColumn<Activite, String> descriptionA;
    @FXML
    private TableColumn<Activite, String> speciesAct;
    @FXML
    private TableColumn<Activite, String> etatAct;
    @FXML
    private TableView<Activite> viewActOuvrier;
private List<Activite> data;
<<<<<<< HEAD
    @FXML
    private JFXButton deconnexion;
=======
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficheActivite();
        editdata();
    }   
    private void AfficheActivite() {
<<<<<<< HEAD
    SigninController signinController = new SigninController();
    String emailOuvrier = signinController.Getemail();

    if (emailOuvrier != null && !emailOuvrier.isEmpty()) {
        // Continuez avec le reste de votre code pour afficher les activités
        ServiceActivite sa = new ServiceActivite();
        data = sa.getAllByEmail(emailOuvrier);
        objetA.setCellValueFactory(new PropertyValueFactory<Activite, String>("objetAct"));
        descriptionA.setCellValueFactory(new PropertyValueFactory<Activite, String>("descriptionAct"));
        speciesAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("speciesRES"));
        etatAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("etatAct"));
        viewActOuvrier.setItems(FXCollections.observableArrayList(data));
    } else {
        // Gérez le cas où l'adresse e-mail n'a pas pu être récupérée.
        System.out.println("L'adresse e-mail est null ou vide.");
    }
}

=======
        

        ServiceActivite sa = new ServiceActivite();
        String email = "hassanjlassi23@gmail.com";
        data = sa.getAllByEmail(email);
        objetA.setCellValueFactory(new PropertyValueFactory<Activite, String>("objetAct"));
        descriptionA.setCellValueFactory(new PropertyValueFactory<Activite, String>("descriptionAct"));
       speciesAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("speciesRES"));
        etatAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("etatAct"));
        viewActOuvrier.setItems(FXCollections.observableArrayList(data));
    }
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    
    private void editdata(){
    etatAct.setCellFactory(TextFieldTableCell.forTableColumn());
etatAct.setOnEditCommit(event -> {
    Activite activite = event.getTableView().getItems().get(event.getTablePosition().getRow());
    activite.setEtatAct(event.getNewValue());
    // Appel à la méthode de mise à jour pour sauvegarder l'état modifié dans la base de données
    ServiceActivite sa = new ServiceActivite();
    sa.modifier(activite);
});
}
<<<<<<< HEAD

   @FXML
    private void deconnexionAction(ActionEvent event) {
        
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/signin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Afficher Terrain"); // Titre de la nouvelle fenêtre
        stage.show();
    } catch (IOException ex) {
        System.out.println("Erreur lors du chargement de l'interface utilisateur : " + ex.getMessage());
    }
    }

=======
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    
}
