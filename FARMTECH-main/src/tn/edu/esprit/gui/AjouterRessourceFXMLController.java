/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import tn.edu.esprit.entities.Ressource;
import tn.edu.esprit.services.ServiceRessource;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AjouterRessourceFXMLController implements Initializable {

    @FXML
    private RadioButton typeRes1;
    @FXML
    private RadioButton typeRes2;
    @FXML
    private TextField txtSpecies;
    @FXML
    private TextField txtQuantite;
    private final ToggleGroup toggleGroup = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeRes1.setToggleGroup(toggleGroup);
        typeRes2.setToggleGroup(toggleGroup);
    }    

    @FXML
    private void AjouterRessource(ActionEvent event) {
        ServiceRessource sr = new ServiceRessource();
        String type = "";
        if (typeRes1.isSelected()) {
            type = "animaux";
        } else if (typeRes2.isSelected()) {
            type = "plantes";
        }
        
        int quantite = 0;
        try {
            quantite = Integer.parseInt(txtQuantite.getText());
        } catch (NumberFormatException e) {}
        sr.ajouter(new Ressource( type ,txtSpecies.getText(), quantite));
    }
    

    @FXML
    private void RetourAjoutRes(ActionEvent event) {
    }
    
}
