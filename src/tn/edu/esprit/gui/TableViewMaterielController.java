/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import javafx.util.converter.FloatStringConverter;

import java.io.PrintStream;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
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
    private TableColumn<Materiel, Float> fxQunatite;
    @FXML
    private TableColumn<Materiel, Boolean> fxEtat;
    @FXML
    private TableColumn<Materiel, Date> fxDate;
        private List<Materiel>  listeMateriel;
       ServiceMateriel smateriel = new ServiceMateriel();

    private Parc selectedParc ;
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
    List<Materiel> materiels = sm.getAllMaterielsForParc(idParc);
    
    // Mettez à jour la TableView
    fxTableMateriel.setItems(FXCollections.observableArrayList(materiels));
   
    // Set cell value factories
    fxNom.setCellValueFactory(new PropertyValueFactory<>("nomParc"));
    fxNomMateriel.setCellValueFactory(new PropertyValueFactory<>("nomMat"));
    fxQunatite.setCellValueFactory(new PropertyValueFactory<>("quantiteMat"));
    fxEtat.setCellValueFactory(new PropertyValueFactory<>("etatMat"));
    fxDate.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
}

/*
private void editData(){

    fxNomMateriel.setCellFactory(TextFieldTableCell.<Materiel>forTableColumn());
    fxNomMateriel.setOnEditCommit(event -> {
        Materiel materiel = event.getTableView().getItems().get(event.getTablePosition().getRow());
        materiel.setNomMat(event.getNewValue());
        smateriel.modifierMateriel(materiel);
    });

    fxQunatite.setCellFactory(TextFieldTableCell.<Materiel, Float>forTableColumn(new FloatStringConverter()));
    fxQunatite.setOnEditCommit(event -> {
        Materiel materiel = event.getTableView().getItems().get(event.getTablePosition().getRow());
        Float newValue = event.getNewValue();
        if (newValue != null && !newValue.isNaN()) {
            try {
                Float quantite = newValue;
                materiel.setQuantiteMat(quantite);
                 ServiceMateriel smateriel = new ServiceMateriel();
                    smateriel.modifierMateriel(materiel);            
            } catch (NumberFormatException e) {
                System.out.println("La valeur entrée n'est pas un nombre valide.");
            }
        } else {
            System.out.println("valeur est invalide");
        }
    });

}
*/
    @FXML
    private void fxSupprimer(ActionEvent event) {
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

    @FXML
    private void fxbacktoTableViewParc(ActionEvent event) throws IOException {
        
    try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GetAllFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Liste de materiels");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterMaterielFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}