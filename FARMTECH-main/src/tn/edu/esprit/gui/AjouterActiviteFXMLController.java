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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Activite;
import tn.edu.esprit.services.ServiceActivite;

/**
 * FXML Controller class
 *
 * @author rihab
 */
public class AjouterActiviteFXMLController implements Initializable {

    @FXML
    private TextField txtObjetA;
    @FXML
    private TextField txtDistA;
    @FXML
    private TextField txtDescriptionA;
    @FXML
    private TextField txtEmaildistA;
    @FXML
    private CheckBox checkActivite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterActivite(ActionEvent event) {
        String objet = txtObjetA.getText();
    String dist = txtDistA.getText();
    String description = txtDescriptionA.getText();
    String emailDist = txtEmaildistA.getText();

   
    ServiceActivite serviceActivite = new ServiceActivite();
    Activite activite = new Activite(objet,  description, dist , emailDist);
    serviceActivite.ajouter(activite);
    }

    @FXML
    private void RetourAjoutAct(ActionEvent event) {
    }
    
}
