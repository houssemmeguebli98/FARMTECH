package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Parc;
import tn.edu.esprit.services.ServiceParc;

public class GetAllFXMLController implements Initializable {

   

    
    @FXML
    private TableView<Parc> fxTableParc;
    @FXML
    private TableColumn<Parc, String> fxNom;
    @FXML
    private TableColumn<Parc, String> fxAdresse;
    @FXML
    private TableColumn<Parc, String> fxSuperficie;

    private List<Parc> data;
    @FXML
    private TextField fxtextchercher;
        ServiceParc sp = new ServiceParc();
    @FXML
    private Label fxnotfound;
    @FXML
    private Button fxTransferButton;
    private Parc selectedParc;
    

    
   @Override
public void initialize(URL url, ResourceBundle rb) {
    fxAfficher(new ActionEvent());
    fxChercher(new ActionEvent()); 
    fxnotfound.setVisible(false);
    editData();

    fxTableParc.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            // Un élément a été sélectionné
            fxTransferButton.setVisible(true);
        } else fxTransferButton.setVisible(false);

        // Set the selectedParc here
        selectedParc = newSelection;
    });
}




    @FXML
    private void fxAfficher(ActionEvent event) {
        ServiceParc sp = new ServiceParc();
        data = sp.getAll(); // Assurez-vous que votre ServiceParc retourne une List<Parc>

        fxTableParc.setItems(FXCollections.observableArrayList(data));
        
        fxNom.setCellValueFactory(new PropertyValueFactory<Parc , String>("nomParc"));
        fxAdresse.setCellValueFactory(new PropertyValueFactory<Parc , String>("adresseParc"));
        fxSuperficie.setCellValueFactory(new PropertyValueFactory<Parc , String>("SuperficieParc"));

    }

    @FXML
    private void fxSupprimer(ActionEvent event) {
   ServiceParc sp = new ServiceParc();
    Parc parcSelectionne = fxTableParc.getSelectionModel().getSelectedItem();

    if (parcSelectionne != null) {
        sp.supprimer(parcSelectionne.getIdParc()); // Supprimez l'élément de la base de données

        // Mettez à jour la TableView
        data.remove(parcSelectionne);
        fxTableParc.getItems().setAll(data);
    } else {
        System.out.println("Vous devez sélectionner un élément avant de le supprimer.");
    }
}
    private void editData(){

    // Éditer le nom du parc
    fxNom.setCellFactory(TextFieldTableCell.<Parc>forTableColumn());
    fxNom.setOnEditCommit(event -> {
        Parc parc = event.getTableView().getItems().get(event.getTablePosition().getRow());
        parc.setNomParc(event.getNewValue());
        System.out.println("Le nom de " + parc.getNomParc() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        sp.modifier(parc);
    });

    // Éditer l'adresse du parc
    fxAdresse.setCellFactory(TextFieldTableCell.<Parc>forTableColumn());
    fxAdresse.setOnEditCommit(event -> {
        Parc parc = event.getTableView().getItems().get(event.getTablePosition().getRow());
        parc.setAdresseParc(event.getNewValue());
        System.out.println("L'adresse de " + parc.getAdresseParc() + " a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
    sp.modifier(parc);
    });

    // Éditer la superficie du parc
    fxSuperficie.setCellFactory(TextFieldTableCell.<Parc>forTableColumn());
    fxSuperficie.setOnEditCommit(event -> {
        Parc parc = event.getTableView().getItems().get(event.getTablePosition().getRow());
        parc.setSuperficieParc(event.getNewValue());
        System.out.println("La superficie de " + parc.getSuperficieParc() + " a été mise à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
    sp.modifier(parc);
    });

    // Appeler la fonction modifier(Parc t)
    
    
}

    @FXML
    private void fxChercher(ActionEvent event) {
       String nomCherche = fxtextchercher.getText(); // Récupérer le texte du champ de recherche

    // Appeler la méthode getOne avec le nom cherché
    
    Parc parc = sp.getOne(nomCherche);

    if (parc != null) {
        // Mettre à jour la TableView avec les détails du parc trouvé
           fxnotfound.setVisible(false);

        fxTableParc.getItems().setAll(parc);
    } else {
        System.out.println("Aucun parc trouvé avec ce nom.");
                fxnotfound.setVisible(true);

    }
    }

     

@FXML
private void fxTranfserpage(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/TableViewMateriel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Parc selectedParc = fxTableParc.getSelectionModel().getSelectedItem();

        // Set the selected parc's name to the test TextField
        TableViewMaterielController t = loader.getController();
        t.initData(selectedParc);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Ajouter materiel ");
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}


}


