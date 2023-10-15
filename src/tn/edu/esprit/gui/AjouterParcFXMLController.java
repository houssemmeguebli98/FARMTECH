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
import tn.edu.esprit.entities.Parc;
import tn.edu.esprit.services.ServiceParc;

/**
 * FXML Controller class
 *
 * @author megbl
 */
public class AjouterParcFXMLController implements Initializable {

    @FXML
    private TextField fxNomParc;
    @FXML
    private TextField fxAdresseParc;
    @FXML
    private TextField fxSuperficieParc;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void fxAjouterParc(ActionEvent event) {  
        ServiceParc sp = new ServiceParc();
          sp.ajouter(new Parc(fxNomParc.getText(), fxAdresseParc.getText(), fxSuperficieParc.getText()));
    }
}
/*
    @FXML
    private void ShowParc (ActionEvent event) {
        ServiceParc sp = new ServiceParc();
         ShowPersonne.setText(sp.getAll().toString());
         ShowParc.setText(sp.getAll().toString());
    }
*/