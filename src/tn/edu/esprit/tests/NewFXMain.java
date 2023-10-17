/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tests;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author megbl
 */
public class NewFXMain extends Application {
    
  
   @Override
    public void start(Stage primaryStage) {
                  /*
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterParcFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("/*******Ajouter Parc /******");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            */
          try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/GetAllFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Liste de parc ");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       /*
          try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/AjouterMaterielFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter materiel ");
            primaryStage.show();
        
        } catch (IOException ex) { 
            System.out.println(ex.getMessage());
        }
       

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/TableAllMateriel.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Liste des materiels ");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

       */ 
           } 
    public static void main(String[] args) {
        launch(args);
    }
    
}
