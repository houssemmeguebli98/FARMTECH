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
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Terrain;
import tn.edu.esprit.services.ServiceTerrain;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AjouterTerrainFXMLController implements Initializable {

    @FXML
    private TextField txtNomTerrain;
    @FXML
    private TextField txtSuperficieTerrain;
    @FXML
    private TextField txtLocalisation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterTerrain(ActionEvent event) {
        ServiceTerrain st = new ServiceTerrain();
          st.ajouter(new Terrain(txtNomTerrain.getText(), txtLocalisation.getText(), (txtSuperficieTerrain.getText())));
    }

    @FXML
    private void RetourAjout(ActionEvent event) {
    }
    
}
