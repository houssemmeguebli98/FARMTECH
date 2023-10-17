/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmtech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import tn.edu.esprit.entities.Admin;
import tn.edu.esprit.tools.DataSource;
import tn.edu.esprit.entities.Agriculteur;
import tn.edu.esprit.entities.veterinaire;
import tn.edu.esprit.entities.ouvrier;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.entities.UserRole;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.services.IService;

public class FARMTECH {
    public static void main(String[] args) {
        System.out.println("hello");

       // Créez une instance de DataSource pour établir la connexion à la base de données
        DataSource dataSource = DataSource.getInstance();

        // Créez une instance de ServiceUser
        ServiceUser service = new ServiceUser();

        ouvrier ouv = new ouvrier("Nom", "Prenom", "email2@example.com", "0123456789", "MotDePasse", "Tunis", "M","mecanicien");

        // Ajoutez l'Agriculteur à la base de données
        User createdUser = service.create(ouv);

        if (createdUser != null) {
            System.out.println("Utilisateur créé avec succès.");
        } else {
            System.out.println("Échec de la création de l'utilisateur.");
        }

        
      
    
    ServiceUser userService = new ServiceUser();
    userService.delete(4);

        System.out.println("enjazczk");
    }  
}
    
    

