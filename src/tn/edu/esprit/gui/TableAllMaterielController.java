/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
public class TableAllMaterielController implements Initializable {

    @FXML
    private Button fxSuppMat;
    @FXML
    private TableView<Materiel> fxAllMateriel;
    @FXML
    private TableColumn<Materiel, String> fxNomParc;
    @FXML
    private TableColumn<Materiel, String> fxNomMat;
    @FXML
    private TableColumn<Materiel, Float> fxQuantMat;
    @FXML
    private TableColumn<Materiel, Boolean> fxEtatMat;
    @FXML
    private TableColumn<Materiel, LocalDate> fxDateMat;

    @FXML
    private TextField fxChercheField;
    @FXML
    private Label fxNotFound;
    

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
     fxAfficherAll(new ActionEvent());
     

    fxAllMateriel.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            // Un élément a été sélectionné
            fxSuppMat.setVisible(true);
        } else {
            fxSuppMat.setVisible(false);
        }
    });
    }

    @FXML
    private void fxSupp(ActionEvent event) {
 
    Materiel materielSelectionne = fxAllMateriel.getSelectionModel().getSelectedItem();

    if (materielSelectionne != null) {
        String nomMateriel = materielSelectionne.getNomMat();
        ServiceMateriel sm = new ServiceMateriel();
        sm.supprimerMateriel(nomMateriel);

        // Mettez à jour la TableView après la suppression
        List<Materiel> materiels = sm.getAllMateriels(); // Mettez à jour la liste des matériels
        fxAllMateriel.getItems().setAll(materiels);
    } else {
        System.out.println("Aucun matériel sélectionné.");
    }
}

   @FXML
private void fxChercher(ActionEvent event) {
    String nomCherche = fxChercheField.getText(); // Récupérer le texte du champ de recherche

    // Appeler la méthode getMaterielByNom avec le nom cherché
    ServiceMateriel sm = new ServiceMateriel();
    List<Materiel> materiels = sm.getMaterielByNom(nomCherche);

    if (!materiels.isEmpty()) {
        // Mettre à jour la TableView avec les détails des matériels trouvés
        fxNotFound.setVisible(false);
        fxAllMateriel.getItems().setAll(materiels);
    } else {
        System.out.println("Aucun matériel trouvé avec ce nom.");
        fxNotFound.setVisible(true);
    }
}

    
@FXML
private void fxAfficherAll(ActionEvent event) {
    ServiceMateriel smateriel = new ServiceMateriel();
    List<Materiel> materiels = smateriel.getAllMateriels();
    
    // Assurez-vous d'ajuster le type de TableView en conséquence
    TableView<Materiel> tableView = (TableView<Materiel>) fxAllMateriel;

    // Mettez à jour la TableView avec la liste de matériel
    tableView.setItems(FXCollections.observableArrayList(materiels));

    // Assurez-vous d'ajuster les TableColumn en conséquence
    TableColumn<Materiel, String> fxNomParcCol = (TableColumn<Materiel, String>) fxNomParc;
    TableColumn<Materiel, String> nomMatCol = (TableColumn<Materiel, String>) fxNomMat;
    TableColumn<Materiel, Float> quantMatCol = (TableColumn<Materiel, Float>) fxQuantMat;
    TableColumn<Materiel, Boolean> etatMatCol = (TableColumn<Materiel, Boolean>) fxEtatMat;
    TableColumn<Materiel, LocalDate> dateMatCol = (TableColumn<Materiel, LocalDate>) fxDateMat;

    // Assurez-vous que les CellValueFactory sont corrects
    fxNomParcCol.setCellValueFactory(new PropertyValueFactory<>("nomParc"));
    nomMatCol.setCellValueFactory(new PropertyValueFactory<>("nomMat"));
    quantMatCol.setCellValueFactory(new PropertyValueFactory<>("quantiteMat"));
    etatMatCol.setCellValueFactory(new PropertyValueFactory<>("etatMat"));
    dateMatCol.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
}
/*
private void editData(){

    // Éditer le nom du matériel
    fxNomMat.setCellFactory(TextFieldTableCell.<Materiel>forTableColumn());
    fxNomMat.setOnEditCommit(event -> {
        Materiel materiel = event.getTableView().getItems().get(event.getTablePosition().getRow());
        materiel.setNomMat(event.getNewValue());
        ServiceMateriel smateriel = new ServiceMateriel();
       smateriel.modifierMateriel(materiel);
    });

    // Éditer la quantité du matériel
    fxQuantMat.setCellFactory(TextFieldTableCell.<Materiel, Float>forTableColumn(new FloatStringConverter()));
    fxQuantMat.setOnEditCommit(event -> {
        Materiel materiel = event.getTableView().getItems().get(event.getTablePosition().getRow());
        Float newValue = event.getNewValue();
        if (newValue != null && !newValue.isNaN()) {
            try {
                Float quantite = newValue;
                materiel.setQuantiteMat(quantite);
        ServiceMateriel smateriel = new ServiceMateriel();
        smateriel.modifierMateriel(materiel);            } catch (NumberFormatException e) {
                System.out.println("La valeur entrée n'est pas un nombre valide.");
            }
        } else {
            System.out.println("La valeur entrée n'est pas valide.");
        }
    });
   fxEtatMat.setCellFactory(col -> new TableCell<Materiel, Boolean>() {
    private final RadioButton btnON = new RadioButton("ON");
    private final RadioButton btnOff = new RadioButton("OFF");
    private final ToggleGroup group = new ToggleGroup();

    {
        btnON.setToggleGroup(group);
        btnOff.setToggleGroup(group);

        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                boolean etat = newValue == btnON;
                Materiel materiel = getTableView().getItems().get(getIndex());
                materiel.setEtatMat(etat);
                ServiceMateriel smateriel = new ServiceMateriel();
                smateriel.modifierMateriel(materiel);
            }
        });
    }

    public void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            boolean etat = item;
            btnON.setSelected(etat);
            btnOff.setSelected(!etat);
            setGraphic(btnON);
        }
    }
});

  

}*/
    @FXML
    private void Fxgotoupdtae(ActionEvent event) {
         try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ModifierMaterielFXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Materiel selectedMateriel = new Materiel();
        selectedMateriel = fxAllMateriel.getSelectionModel().getSelectedItem();
        SelectedParcManager.setSelectedMateriel(selectedMateriel);
        if (selectedMateriel != null) {
          
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Modifier materiel ");
            stage.show();
        } else {
            System.out.println("Aucun materil sélectionné.");
        }
    } catch (IOException ex) {
        System.out.println("Erreur lors du chargement de l'interface utilisateur : " + ex.getMessage());
    }
}
    
}

    
    

