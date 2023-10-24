/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Message;

/**
 * FXML Controller class
 *
 * @author megbl
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Reclamations;
import tn.edu.esprit.services.ReclamationService;

public class AjouterReclamationController {

    @FXML
    private TextField typeField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telephoneField;

    @FXML
    private void ajouterReclamation(ActionEvent event) {
        String type = typeField.getText();
        String description = descriptionField.getText();
        String email = emailField.getText();
        String telephone = telephoneField.getText();

        // Create a new Reclamation
        Reclamations reclamation = new Reclamations(type, description, email, telephone);

        // Add the reclamation using the ReclamationService
       
        // You can add further logic for what to do after adding a reclamation
        // For example, show a confirmation message or navigate to another view
    }
}
