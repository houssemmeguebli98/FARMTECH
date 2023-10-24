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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficheActivite();
        editdata();
    }   
    private void AfficheActivite() {
        

        ServiceActivite sa = new ServiceActivite();
        String email = "hassanjlassi23@gmail.com";
        data = sa.getAllByEmail(email);
        objetA.setCellValueFactory(new PropertyValueFactory<Activite, String>("objetAct"));
        descriptionA.setCellValueFactory(new PropertyValueFactory<Activite, String>("descriptionAct"));
       speciesAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("speciesRES"));
        etatAct.setCellValueFactory(new PropertyValueFactory<Activite, String>("etatAct"));
        viewActOuvrier.setItems(FXCollections.observableArrayList(data));
    }
    
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
    
}
