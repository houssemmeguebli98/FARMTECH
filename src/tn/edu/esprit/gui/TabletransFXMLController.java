/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
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
import javafx.scene.control.cell.*;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Transaction;
import tn.edu.esprit.services.Servicetransaction;

/**
 * FXML Controller class
 *
 * @author jouin
 */
public class TabletransFXMLController implements Initializable {
    @FXML
    private TableView<Transaction> transactionstable1;
    @FXML
    private TableColumn<Transaction,Integer> idcolumn;
    @FXML
    private TableColumn<Transaction, String> categoriecolumn;
    @FXML
    private TableColumn<Transaction, Boolean> typecolumn;
    @FXML
    private TableColumn<Transaction, Date> datecolumn;
    @FXML
    private TableColumn<Transaction, Integer> montantcolumn;

    private List<Transaction> data;
    @FXML
    private TextField textcherchertra;
    Servicetransaction st = new Servicetransaction();
    @FXML
    private Label tranotfound;
    @FXML
    private Label tranotfound1;
    @FXML
    private Button buttonajoutertra;
    private Transaction selectedTransaction;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button buttonsupprimertra;
    //@FXML
    //private Button buttonmodifiertra;
    @FXML
    private Button buttoncherchertra;
    @FXML
    private Button buttonaffichertra;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //affichertra(new ActionEvent());
        //cherchertra(new ActionEvent()); 
         //tranotfound.setVisible(false);
        categoriecolumn.setCellValueFactory(new PropertyValueFactory<>("categ_tra"));
        typecolumn.setCellValueFactory(new PropertyValueFactory<>("type_tra"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date_tra"));
        montantcolumn.setCellValueFactory(new PropertyValueFactory<>("montant"));

        //transactionstable1.setItems(observableList);
        transactionstable1.setEditable(true);
        editData();

        transactionstable1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            buttonajoutertra.setVisible(true);
        } else buttonajoutertra.setVisible(false);

        selectedTransaction = newSelection;
    });


    }
    @FXML
    private void supprimertra(ActionEvent event)throws IOException {
   Servicetransaction st = new Servicetransaction();
    Transaction  transacSelectionne = transactionstable1.getSelectionModel().getSelectedItem();

    if (transacSelectionne != null) {
        st.supprimer(transacSelectionne.getId_tra()); // Supprimez l'élément de la base de données

        // Mettez à jour la TableView
        data.remove(transacSelectionne);
        transactionstable1.getItems().setAll(data);
    } else {
        System.out.println("Vous devez sélectionner un élément avant de le supprimer.");
    }
}   @FXML
    private void editData() {
    //edit categorie
    categoriecolumn.setCellFactory(TextFieldTableCell.<Transaction>forTableColumn());
    categoriecolumn.setOnEditCommit(event -> {
        Transaction transaction = event.getTableView().getItems().get(event.getTablePosition().getRow());
        transaction.setCateg_tra(event.getNewValue());
        System.out.println("Le nom de " + transaction.getCateg_tra() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        st.modifier(transaction);
    });
   /* //edit type
    typecolumn.setCellFactory(TextFieldTableCell.<Transaction>forTableColumn());
    typecolumn.setOnEditCommit(event -> {
        Transaction transaction = event.getTableView().getItems().get(event.getTablePosition().getRow());
        transaction.setType_tra(event.getNewValue());
        System.out.println("Le nom de " + transaction.getCateg_tra() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        st.modifier(transaction);
    });
//edit categorie
    datecolumn.setCellFactory(DatePickerTableCell.<Transaction>forTableColumn());
    datecolumn.setOnEditCommit(event -> {
        Transaction transaction = event.getTableView().getItems().get(event.getTablePosition().getRow());
        transaction.setCateg_tra(event.getNewDate());
        System.out.println("Le nom de " + transaction.getCateg_tra() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        st.modifier(transaction);
    });
//edit categorie
    montantcolumn.setCellFactory(TextFieldTableCell.<Transaction>forTableColumn());
    montantcolumn.setOnEditCommit(event -> {
        Transaction transaction = event.getTableView().getItems().get(event.getTablePosition().getRow());
        transaction.setCateg_tra(event.getNewValue());
        System.out.println("Le nom de " + transaction.getCateg_tra() + " a été mis à jour à " + event.getNewValue() + " à la ligne " + (event.getTablePosition().getRow() + 1));
        st.modifier(transaction);
    });*/}
    
    @FXML
    private void affichertra(ActionEvent actionEvent) throws IOException{
        Servicetransaction servicetransaction = new Servicetransaction();
        data = servicetransaction.getAll(); // Assurez-vous que votre ServiceParc retourne une List<Parc>

        transactionstable1.setItems(FXCollections.observableArrayList(data));
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id_tra"));
        categoriecolumn.setCellValueFactory(new PropertyValueFactory<>("categ_tra"));
        //categoriecolumn.setCellValueFactory(new PropertyValueFactory<Transaction , String>("categ_tra"));
        typecolumn.setCellValueFactory(new PropertyValueFactory<>("type_tra"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date_tra"));
        montantcolumn.setCellValueFactory(new PropertyValueFactory<>("montant"));
    }
    @FXML
    private void cherchertra(ActionEvent actionEvent)throws IOException{
        //String nomCherche = textcherchertra.getText(); // Récupérer le texte du champ de recherche
        tranotfound1.setText("");
        tranotfound.setText("");
        if (textcherchertra.getText().isEmpty()) {
        tranotfound.setText("Entrez un id");
        return;
        }
        String textInput= textcherchertra.getText();
        int id_tra = Integer.parseInt(textInput);
        Transaction transaction = st.getOne(id_tra);

    if (transaction != null) {
        // Mettre à jour la TableView avec les détails du parc trouvé
        if(transaction.getId_tra()!= 0){
            tranotfound1.setText("transaction disponible");  
            transactionstable1.getItems().setAll(transaction);
         } else {
           tranotfound.setText("transaction non disponible");}
    } else {
        System.out.println("Aucune transaction trouvée avec cet id.");
                tranotfound.setVisible(true);

    }    }
    
    @FXML
    private void ajoutertrans(ActionEvent event) throws IOException {
        
            root = FXMLLoader.load(getClass().getResource("../gui/ajouterFXML.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    @FXML
    private void categoriecat(ActionEvent event) throws IOException {
           root = FXMLLoader.load(getClass().getResource("../gui/tresorerieFXML.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("trésorerie");
            stage.show();

    }
}

   

