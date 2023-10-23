/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aladi
 */
public class ForgetPassword2Controller implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private JFXTextField codeField;
    @FXML
    private JFXButton validerButton;
    @FXML
    private JFXButton RenvoyercodeButton;

    /**
     * Initializes the controller class.
     */
    
    public void setEmail(String email) {
        emailField.setText(email);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validerAction(ActionEvent event) {
    }

    @FXML
    private void RenvoyercodeAction(ActionEvent event) {
    }
    
}
