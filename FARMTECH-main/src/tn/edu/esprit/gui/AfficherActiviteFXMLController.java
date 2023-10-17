/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import tn.edu.esprit.entities.Activite;
import tn.edu.esprit.services.ServiceActivite;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AfficherActiviteFXMLController implements Initializable {

   @FXML
    private TableView<Activite> viewActivite;
    private List<Activite> data;
    @FXML
    private TableColumn<Activite, String> objetA;
    @FXML
    private TableColumn<Activite, String> descriptionA;
    @FXML
    private TableColumn<Activite, String> distinataireA;
    @FXML
    private TableColumn<Activite, String> EmailDisA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editData();
    }    

    @FXML
    private void AfficheActivite(ActionEvent event) {
        ServiceActivite sa = new ServiceActivite();
        Activite a = new Activite();
        data = sa.getAll(a);
        objetA.setCellValueFactory(new PropertyValueFactory<Activite, String>("objetAct"));
        descriptionA.setCellValueFactory(new PropertyValueFactory<Activite, String>("descriptionAct"));
        distinataireA.setCellValueFactory(new PropertyValueFactory<Activite, String>("distAct"));
        EmailDisA.setCellValueFactory(new PropertyValueFactory<Activite, String>("emailDist"));

        viewActivite.setItems(FXCollections.observableArrayList(data));
    }

    @FXML
    private void SupprimerActivite(ActionEvent event) {
        Activite activiteSelectionnee = viewActivite.getSelectionModel().getSelectedItem();

        if (activiteSelectionnee != null) {
            ServiceActivite serviceActivite = new ServiceActivite();
            serviceActivite.supprimer(activiteSelectionnee.getIdAct()); // Supprimez l'activité de la base de données

            // Mettez à jour la TableView
            data.remove(activiteSelectionnee);
            viewActivite.getItems().setAll(data);
        } else {
            System.out.println("Vous devez sélectionner une activité avant de la supprimer.");
        }
    }
    
    
    private void editData() {
    objetA.setCellFactory(TextFieldTableCell.<Activite>forTableColumn());
    objetA.setOnEditCommit(event -> {
        Activite activite = event.getTableView().getItems().get(event.getTablePosition().getRow());
        activite.setObjetAct(event.getNewValue());
        System.out.println("L'objet de l'activité a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceActivite sa = new ServiceActivite();
        sa.modifier(activite);
    });

    descriptionA.setCellFactory(TextFieldTableCell.<Activite>forTableColumn());
    descriptionA.setOnEditCommit(event -> {
        Activite activite = event.getTableView().getItems().get(event.getTablePosition().getRow());
        activite.setDescriptionAct(event.getNewValue());
        System.out.println("La description de l'activité a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceActivite sa = new ServiceActivite();
        sa.modifier(activite);
    });

    distinataireA.setCellFactory(TextFieldTableCell.<Activite>forTableColumn());
    distinataireA.setOnEditCommit(event -> {
        Activite activite = event.getTableView().getItems().get(event.getTablePosition().getRow());
        activite.setDistAct(event.getNewValue());
        System.out.println("Le destinataire de l'activité a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceActivite sa = new ServiceActivite();
        sa.modifier(activite);
    });

    EmailDisA.setCellFactory(TextFieldTableCell.<Activite>forTableColumn());
    EmailDisA.setOnEditCommit(event -> {
        Activite activite = event.getTableView().getItems().get(event.getTablePosition().getRow());
        activite.setEmailDist(event.getNewValue());
        System.out.println("L'e-mail du destinataire de l'activité a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceActivite sa = new ServiceActivite();
        sa.modifier(activite);
    });
}

        
    }
    
