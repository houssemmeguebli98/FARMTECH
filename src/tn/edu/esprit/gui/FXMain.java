/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

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
 * @author jouin*/
 
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
   /* try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/Tableviewtrans.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("/*******Ajouter Transaction /******");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    */
   try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/tresorerieFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Trésorerie");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
   /*try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/ajouterFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter transaction ");
            primaryStage.show();
        
        } catch (IOException ex) { 
            System.out.println(ex.getMessage());
    
    }}*/
    public static void main(String[] args) {
        launch(args);
    }
   
}