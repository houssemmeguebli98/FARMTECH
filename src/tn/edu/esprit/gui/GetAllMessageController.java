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
    private Button fxTransferButton;
    @FXML
    private Button fxAddMaterialButton;

    private MessageService messageService = new MessageService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the table columns
        fxId.setCellValueFactory(new PropertyValueFactory<>("id"));
        fxText.setCellValueFactory(new PropertyValueFactory<>("text"));
        fxDestinataire.setCellValueFactory(new PropertyValueFactory<>("destinataire"));
        fxSource.setCellValueFactory(new PropertyValueFactory<>("source"));
        fxDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Make text column editable
        fxText.setCellFactory(TextFieldTableCell.forTableColumn());

        // Listen for selection changes and show the details when changed.
        fxTableMessage.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

        // Load data into the table
        fxAfficher(new ActionEvent());
    }

    @FXML
    private void fxAfficher(ActionEvent event) {
        List<Message> data = messageService.getAll();
        ObservableList<Message> messageList = FXCollections.observableArrayList(data);
        fxTableMessage.setItems(messageList);
    }

    @FXML
    private void fxSupprimer(ActionEvent event) {
        Message messageSelectionne = fxTableMessage.getSelectionModel().getSelectedItem();

        if (messageSelectionne != null) {
            messageService.supprimer(messageSelectionne.getId());

            // Remove from the table view
            fxTableMessage.getItems().remove(messageSelectionne);
        } else {
            System.out.println("Vous devez sélectionner un élément avant de le supprimer.");
        }
    }

    @FXML
    private void fxChercher(ActionEvent event) {
        String textCherche = fxTextChercher.getText();
        List<Message> messages = messageService.searchMessages(textCherche);

        if (!messages.isEmpty()) {
            fxNotFound.setVisible(false);
            fxTableMessage.getItems().setAll(messages);
        } else {
            fxNotFound.setVisible(true);
        }
    }

    private void showDetails(Message message) {
        if (message != null) {
            fxTransferButton.setVisible(true);
            fxAddMaterialButton.setVisible(true);
        } else {
            fxTransferButton.setVisible(false);
            fxAddMaterialButton.setVisible(false);
        }
    }

    @FXML
    private void fxTransferPage(ActionEvent event) {
        // Code to handle transferring to another page
        // You'll need to implement this according to your requirements
        System.out.println("Transfer to another page");
    }

    @FXML
    private void fxAjouterduMat(ActionEvent event) {
        // Code to handle adding material
        // You'll need to implement this according to your requirements
        System.out.println("Add material");
    }

    @FXML
    private void fxMenuGetALL(ActionEvent event) {
        // Code to handle navigating to a menu for GetAll
        // You'll need to implement this according to your requirements
        System.out.println("Go to GetAll menu");
    }

    @FXML
    private void fxGoToAddMessage(ActionEvent event) {
        // Code to handle navigating to AddMessage
        // You'll need to implement this according to your requirements
        System.out.println("Go to AddMessage");
    }
}
