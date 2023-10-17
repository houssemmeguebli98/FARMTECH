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
import javafx.util.converter.IntegerStringConverter;
import tn.edu.esprit.entities.Ressource;
import tn.edu.esprit.services.ServiceRessource;

public class AfficherRessourceFXMLController implements Initializable {

    @FXML
    private TableView<Ressource> viewRessource;
    private List<Ressource> data;
    @FXML
private TableColumn<Ressource, String> typeRes;
@FXML
private TableColumn<Ressource, String> speciesRes;
@FXML
private TableColumn<Ressource, Integer> quantiteRes;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceRessource sr = new ServiceRessource();
         editData();
    }

    @FXML
    private void AfficheRessource(ActionEvent event) {
        ServiceRessource sr = new ServiceRessource();
        Ressource r = new Ressource();
        data = sr.getAll(r);

        viewRessource.setItems(FXCollections.observableArrayList(data));

        typeRes.setCellValueFactory(new PropertyValueFactory<Ressource, String>("typeRes"));
        speciesRes.setCellValueFactory(new PropertyValueFactory<Ressource, String>("speciesRes"));
        quantiteRes.setCellValueFactory(new PropertyValueFactory<Ressource, Integer>("quantiteRes"));
    }

    @FXML
    private void SupprimerRessource(ActionEvent event) {
        Ressource ressourceSelectionnee = viewRessource.getSelectionModel().getSelectedItem();

        if (ressourceSelectionnee != null) {
            ServiceRessource sr = new ServiceRessource();
            sr.supprimer(ressourceSelectionnee.getIdRes()); // Supprimez l'élément de la base de données

            // Mettez à jour la TableView
            data.remove(ressourceSelectionnee);
            viewRessource.getItems().setAll(data);
        } else {
            System.out.println("Vous devez sélectionner une ressource avant de la supprimer.");
        }
    }
    
     private void editData() {
    typeRes.setCellFactory(TextFieldTableCell.<Ressource>forTableColumn());
    typeRes.setOnEditCommit(event -> {
        Ressource ressource = event.getTableView().getItems().get(event.getTablePosition().getRow());
        ressource.setTypeRes(event.getNewValue());
        System.out.println("Le type de ressource a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceRessource sr = new ServiceRessource();
        sr.modifier(ressource);
    });

    speciesRes.setCellFactory(TextFieldTableCell.<Ressource>forTableColumn());
    speciesRes.setOnEditCommit(event -> {
        Ressource ressource = event.getTableView().getItems().get(event.getTablePosition().getRow());
        ressource.setSpeciesRes(event.getNewValue());
        System.out.println("le species de ressource a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceRessource sr = new ServiceRessource();
        sr.modifier(ressource);
    });

    quantiteRes.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    quantiteRes.setOnEditCommit(event -> {
        Ressource ressource = event.getTableView().getItems().get(event.getTablePosition().getRow());
        ressource.setQuantiteRes(event.getNewValue());
        System.out.println("La quantité de ressource a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceRessource sr = new ServiceRessource();
        sr.modifier(ressource);
    });
}
    
}
