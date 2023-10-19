package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import tn.edu.esprit.entities.Message;
import tn.edu.esprit.services.MessageService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import tn.edu.esprit.entities.Message;
import tn.edu.esprit.services.MessageService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GetAllMessageController implements Initializable {

    @FXML
    private TableView<Message> fxTableMessage;
    @FXML
    private TableColumn<Message, Integer> fxId;
    @FXML
    private TableColumn<Message, String> fxText;
    @FXML
    private TableColumn<Message, String> fxDestinataire;
    @FXML
    private TableColumn<Message, String> fxSource;
    @FXML
    private TableColumn<Message, String> fxDate;
    @FXML
    private TextField fxTextChercher;
    @FXML
    private Label fxNotFound;
     @FXML
    private Label fxmessage;
    private Button fxTransferButton;
    private Button fxAddMaterialButton;
     private Stage stage;
    private Scene scene;
    private Parent root;

    private MessageService ms = new MessageService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the table columns
        fxId.setCellValueFactory(new PropertyValueFactory<>("id"));
        fxText.setCellValueFactory(new PropertyValueFactory<>("text"));
        fxDestinataire.setCellValueFactory(new PropertyValueFactory<>("destinataire"));
        fxSource.setCellValueFactory(new PropertyValueFactory<>("source"));
        fxDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Make text column editable
       
    }
     @FXML
    private void fxChercher(ActionEvent event) {
       String nomCherche = fxTextChercher.getText(); // Récupérer le texte du champ de recherche

    // Appeler la méthode getOne avec le nom cherché
   
    Message message = ms.getOne(nomCherche);

    if (message != null) {
        // Mettre à jour la TableView avec les détails du parc trouvé
           fxNotFound.setVisible(false);

        fxTableMessage.getItems().setAll(message);
    } else {
        System.out.println("Aucun parc trouvé avec ce nom.");
                fxNotFound.setText("message n'existe pas");

    }

    }

    

    @FXML
    private void fxAfficher(ActionEvent event) {
        List<Message> data = ms.getAll();
        ObservableList<Message> messageList = FXCollections.observableArrayList(data);
        fxTableMessage.setItems(messageList);
    }

    @FXML
    private void fxSupprimer(ActionEvent event) {
        Message messageSelectionne = fxTableMessage.getSelectionModel().getSelectedItem();

        if (messageSelectionne != null) {
            ms.supprimer(messageSelectionne.getId());

            // Remove from the table view
            fxTableMessage.getItems().remove(messageSelectionne);
             fxmessage.setText("message supprimé");
        } else {
            System.out.println("Vous devez sélectionner un élément avant de le supprimer.");
                        fxmessage.setText("selectionnez un message");

        }
    }

        

    


    @FXML
    private void fxMenuGetALL(ActionEvent event) throws IOException {
       /* // Code to handle transferring to another page
        // You'll need to implement this according to your requirements
        System.out.println("Transfer to another page");
*/
        root = FXMLLoader.load(getClass().getResource("../gui/ajouterFXML.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

}

    @FXML
    private void fxGoToAddMessage(ActionEvent event) throws IOException {
        // Code to handle adding material
        // You'll need to implement this according to your requirements
        root = FXMLLoader.load(getClass().getResource("AjouterMessage.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
       // System.out.println("Add material");
    }

    /*private void fxAjouterduMat(ActionEvent event) {
        // Code to handle navigating to a menu for GetAll
        // You'll need to implement this according to your requirements
        System.out.println("Go to GetAll menu");
    }

    private void fxTransferPage(ActionEvent event) {
        // Code to handle navigating to AddMessage
        // You'll need to implement this according to your requirements
        System.out.println("Go to AddMessage");
    }*/

    private void Editdata() {
        fxText.setCellFactory(TextFieldTableCell.forTableColumn()); 
        fxText.setOnEditCommit(event -> {
        Message message = event.getTableView().getItems().get(event.getTablePosition().getRow());
        message.setText(event.getNewValue());
        System.out.println("Le nom de " + message.getText() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ms.modifier(message);
    });
        fxDestinataire.setCellFactory(TextFieldTableCell.forTableColumn()); 
        fxDestinataire.setOnEditCommit(event -> {
        Message message = event.getTableView().getItems().get(event.getTablePosition().getRow());
        message.setDestinataire(event.getNewValue());
        System.out.println("Le nom de " + message.getDestinataire() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ms.modifier(message);
    });
        fxSource.setCellFactory(TextFieldTableCell.forTableColumn()); 
        fxSource.setOnEditCommit(event -> {
        Message message = event.getTableView().getItems().get(event.getTablePosition().getRow());
        message.setSource(event.getNewValue());
        System.out.println("Le nom de " + message.getSource() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ms.modifier(message);
    });

    
    }
}

    

