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
import tn.edu.esprit.entities.Terrain;
import tn.edu.esprit.services.ServiceTerrain;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AfficherTerrainFXMLController implements Initializable {

  
    @FXML
    private TableView<Terrain> viewTerrain;
    @FXML
    private TableColumn<Terrain, String> nomTerrain;
    @FXML
    private TableColumn<Terrain, String> localisation;
    @FXML
    private TableColumn<Terrain, String> superficie;
    private List<Terrain> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editTerrain(); 
    }

   

    @FXML
    private void AfficheTerrain(ActionEvent event) {
    ServiceTerrain sp = new ServiceTerrain();
        Terrain t = new Terrain();
        data = sp.getAll(t);

        viewTerrain.setItems(FXCollections.observableArrayList(data));
        
        nomTerrain.setCellValueFactory(new PropertyValueFactory<Terrain , String>("nomTerrain"));
        localisation.setCellValueFactory(new PropertyValueFactory<Terrain , String>("localisation"));
        superficie.setCellValueFactory(new PropertyValueFactory<Terrain , String>("Superficie"));
    }

    @FXML
    private void SupprimerTerrain(ActionEvent event) {
  
    Terrain terrainSelectionne = viewTerrain.getSelectionModel().getSelectedItem();

    if (terrainSelectionne != null) {
        ServiceTerrain st = new ServiceTerrain();
        st.supprimer(terrainSelectionne.getIdTerrain()); // Supprimez l'élément de la base de données

        // Mettez à jour la TableView
        data.remove(terrainSelectionne);
        viewTerrain.getItems().setAll(data);
    } else {
        System.out.println("Vous devez sélectionner un élément avant de le supprimer.");
    }
}
    
    private void editTerrain() {
    nomTerrain.setCellFactory(TextFieldTableCell.forTableColumn());
    nomTerrain.setOnEditCommit(event -> {
        Terrain terrain = event.getTableView().getItems().get(event.getTablePosition().getRow());
        terrain.setNomTerrain(event.getNewValue());
        System.out.println("Le nom du terrain " + terrain.getNomTerrain() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceTerrain st = new ServiceTerrain();
        st.modifier(terrain);
    });

    localisation.setCellFactory(TextFieldTableCell.forTableColumn());
    localisation.setOnEditCommit(event -> {
        Terrain terrain = event.getTableView().getItems().get(event.getTablePosition().getRow());
        terrain.setLocalisation(event.getNewValue());
        System.out.println("La localisation du terrain " + terrain.getLocalisation() + " a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceTerrain st = new ServiceTerrain();
        st.modifier(terrain);
    });

    superficie.setCellFactory(TextFieldTableCell.forTableColumn());
    superficie.setOnEditCommit(event -> {
        Terrain terrain = event.getTableView().getItems().get(event.getTablePosition().getRow());
        terrain.setSuperficie(event.getNewValue());
        System.out.println("La superficie du terrain " + terrain.getSuperficie() + " a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        ServiceTerrain st = new ServiceTerrain();
        st.modifier(terrain);
    });
} 
    }
