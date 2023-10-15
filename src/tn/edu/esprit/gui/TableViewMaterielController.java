/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.entities.Parc;
import tn.edu.esprit.services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author megbl
 */
public class TableViewMaterielController implements Initializable {
GetAllFXMLController tableparc;
    @FXML
    private TableView<Materiel> fxTableMateriel;
    @FXML
    private TableColumn<Materiel, String> fxNom;
    @FXML
    private TableColumn<Materiel, String> fxNomMateriel;
    @FXML
    private TableColumn<Materiel, String> fxQunatite;
    @FXML
    private TableColumn<Materiel, String> fxEtat;
    @FXML
    private TableColumn<Materiel, Date> fxDate;
        private List<Materiel>  listeMateriel;
    private Parc selectedParc ;
    @FXML
    private Button fxSuppMat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
fxTableMateriel.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
        // Un élément a été sélectionné
       fxSuppMat.setDisable(false); // Activer le bouton de suppression
    } else {
        fxSuppMat.setDisable(true); // Désactiver le bouton de suppression s'il n'y a pas de sélection
    }

});

    }
      

  public void initData(Parc selectedParc) {
        
        int idParc = selectedParc.getIdParc();
        ServiceMateriel sm = new ServiceMateriel();
        Materiel materiel = sm.getOneMateriel(idParc);
        
        // Créez une liste contenant le seul matériel obtenu
        List<Materiel> materiels = new ArrayList<>();
        materiels.add(materiel);
        // Mettez à jour la TableView
        fxTableMateriel.setItems(FXCollections.observableArrayList(materiels));
       
        // Set cell value factories
        fxNom.setCellValueFactory(new PropertyValueFactory<>("nomParc"));
        fxNomMateriel.setCellValueFactory(new PropertyValueFactory<>("nomMat"));
        fxQunatite.setCellValueFactory(new PropertyValueFactory<>("quantiteMat"));
        fxEtat.setCellValueFactory(new PropertyValueFactory<>("etatMat"));
        fxDate.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
    }
  
@FXML

private void fxSupprimerMat(ActionEvent event) {
    ServiceMateriel sm = new ServiceMateriel();
    Materiel MaterielSelectionne = fxTableMateriel.getSelectionModel().getSelectedItem();

    if (fxTableMateriel != null && sm != null &&  listeMateriel != null && MaterielSelectionne != null) {
        sm.supprimerMateriel(MaterielSelectionne.getNomMat()); // Supprimez l'élément de la base de données

        // Mettez à jour la TableView
         listeMateriel.remove(MaterielSelectionne);
        fxTableMateriel.setItems(FXCollections.observableArrayList( listeMateriel));
    } else {
        System.out.println("Une des variables est null.");
    }
}
}


