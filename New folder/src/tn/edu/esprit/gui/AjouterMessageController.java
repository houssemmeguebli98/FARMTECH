/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import tn.edu.esprit.services.MessageService;

public class AjouterMessageController  {
    
   

    @FXML
    private TextField textTextField;

    @FXML
    private TextField destinataireTextField;

    @FXML
    private TextField sourceTextField;

    @FXML
    private TextField dateTextField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void addMessage(ActionEvent event) throws IOException {
        // Retrieve the values from the text fields
      /*  String text = textTextField.getText();
        String destinataire = destinataireTextField.getText();
        String source = sourceTextField.getText();
        String date = dateTextField.getText();
        Date dateform = null;
        date = dateform.parse(date);

        MessageService ms = new MessageService();
        // Create a new message object
        Message message = new Message(text, destinataire, source, date);
        ms.ajouterMessage(message);
        
        // You can perform actions with the message object, e.g., save it to a database
        // For demonstration, let's just print the message
        System.out.println("Message added: " + message);
    }*/
      String text = textTextField.getText();
    String destinataire = destinataireTextField.getText();
    String source = sourceTextField.getText();
    String dateText = dateTextField.getText();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Adjust the format to match your input

    Date date = null;
    try {
        // Parse the date string to a Date object
        date = (Date) dateFormat.parse(dateText);
    } catch (ParseException e) {
        // Handle parsing errors
        System.err.println("Error parsing date: " + e.getMessage());
    }

    if (date != null) {
        // Create a new message object with the parsed date
        MessageService ms = new MessageService();
        Message message = new Message(text, destinataire, source, dateFormat.format(date));
        ms.ajouterMessage(message);

        // You can perform additional actions with the message object, such as saving it to a database.
        System.out.println("Message added: " + message);
            root = FXMLLoader.load(getClass().getResource("GetAllMessage.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    }}
