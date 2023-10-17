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
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.services.ServiceMateriel;

/**
 * FXML Controller class
 *
 * @author megbl
 */
public class ModifierMaterielFXMLController implements Initializable {

    @FXML
    private TextField fxQunMat;
    @FXML
    private TextField fxNomMat;
    @FXML
    private RadioButton fxON;
    @FXML
    private ToggleGroup Etat;
    @FXML
    private RadioButton fxOff;
    @FXML
    private ToggleGroup Etatt;
    private Materiel selectedMateriel ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

 @FXML
private void fxModifier(ActionEvent event) {
    try {
        Materiel selectedMateriel = SelectedParcManager.getSelectedMateriel();

        String nomMat = fxNomMat.getText();
        Float quantite = Float.parseFloat(fxQunMat.getText());
        String etatmateriel = "";
        if(fxON.isSelected()){etatmateriel= "On marche" ;
        }else{etatmateriel= "On panne ";  }

        // Mettez à jour les propriétés du matériel avec les nouvelles valeurs
        selectedMateriel.setNomMat(nomMat);
        selectedMateriel.setQuantiteMat(quantite);
        selectedMateriel.setEtatMat(etatmateriel);

        ServiceMateriel serviceMateriel = new ServiceMateriel();
        serviceMateriel.modifierMateriel(selectedMateriel);

        // Si la modification réussit, vous pouvez effectuer d'autres actions ici.
    } catch (NumberFormatException e) {
        System.out.println("Erreur de format pour la quantité.");
    }
}

    @FXML
    private void fxgotolist(ActionEvent event) {
    }
}

