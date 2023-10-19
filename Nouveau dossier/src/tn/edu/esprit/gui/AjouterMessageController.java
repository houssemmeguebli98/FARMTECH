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


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Message;

public class AjouterMessageController  {
    
   

    @FXML
    private TextField textTextField;

    @FXML
    private TextField destinataireTextField;

    @FXML
    private TextField sourceTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    public void addMessage() {
        // Retrieve the values from the text fields
        String text = textTextField.getText();
        String destinataire = destinataireTextField.getText();
        String source = sourceTextField.getText();
        String date = dateTextField.getText();

        // Create a new message object
        Message message = new Message(text, destinataire, source, date);

        // You can perform actions with the message object, e.g., save it to a database
        // For demonstration, let's just print the message
        System.out.println("Message added: " + message);
    }
}
