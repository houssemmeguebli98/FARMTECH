/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author megbl
 */
public class AjouterMaterielFXMLController implements Initializable {

    @FXML
    private TextField fxQunMat;
    @FXML
    private TextField fxNomMat;
    @FXML
    private RadioButton fxON;
    @FXML
    private RadioButton fxOff;
    @FXML
    private ToggleGroup Etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void fxSaveMateriel(ActionEvent event) {
         // Récupérer les valeurs des champs
        String nomMat = fxNomMat.getText();
        float quantiteMat = Float.parseFloat(fxQunMat.getText());
        boolean etatMat = fxON.isSelected(); // Si fxON est sélectionné, etatMat est true ; sinon false

        // Appeler la méthode d'ajout de matériel
        ServiceMateriel serviceMateriel = new ServiceMateriel();
        Materiel nouveauMateriel = new Materiel();
        nouveauMateriel.setNomMat(nomMat);
        nouveauMateriel.setQuantiteMat(quantiteMat);
        nouveauMateriel.setEtatMat(etatMat);
        nouveauMateriel.setIdParc(24);
        nouveauMateriel.setDateAjout(LocalDate.now());
        serviceMateriel.ajouterMateriel(nouveauMateriel);
        
        // Ajouter ici le code pour retourner à l'interface principale ou faire autre chose
    }
    
}
