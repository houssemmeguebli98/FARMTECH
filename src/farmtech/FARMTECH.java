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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FARMTECH {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("hello");

       // Créez une instance de DataSource pour établir la connexion à la base de données
    DataSource dataSource = DataSource.getInstance();

    // Créez une instance de ServiceUser
    ServiceUser service = new ServiceUser();
    String email = "email@admin.com";
    String password = "aqw"; // Mot de passe non crypté

    // Hachez le mot de passe avec SHA-256
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(password.getBytes());
    byte[] hashedPassword = md.digest();

    // Convertissez le tableau de bytes haché en une chaîne hexadécimale
    StringBuilder hexString = new StringBuilder();
    for (byte b : hashedPassword) {
        hexString.append(String.format("%02x", b));
    }
    String hashedPasswordString = hexString.toString();

    // Maintenant, insérez l'utilisateur dans la base de données avec le mot de passe haché


    // Créez un nouvel administrateur
    Admin admin = new Admin("Ben Mahmoud", "Ala", "email@admin.com", "0123456789", hashedPasswordString);

    // Ajoutez l'administrateur à la base de données
    User createdUser = service.create(admin);

    if (createdUser != null) {
        System.out.println("Administrateur créé avec succès.");
    } else {
        System.out.println("Échec de la création de l'administrateur.");
    }
     Connection connection = DataSource.getInstance().getConnection();

        if (connection != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Connection to the database failed.");
            return;
        }

        // Créez une instance de ServiceUser
         ServiceUser userService = new ServiceUser();

        // Appelez la méthode getAll() pour récupérer la liste des utilisateurs
        List<User> users = userService.getAll();

        // Affichez les utilisateurs dans la console
        for (User user : users) {
            System.out.println(user);
        }

        // N'oubliez pas de fermer la connexion à la base de données lorsque vous avez terminé
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        
      
    
    /*ServiceUser userService = new ServiceUser();
    userService.delete(4);

        System.out.println("enjazczk");*/
        System.out.println("hello");

    /*Créez une instance de DataSource pour établir la connexion à la base de données
    DataSource dataSource = DataSource.getInstance();

    // Créez une instance de ServiceUser
    ServiceUser serviceUser = new ServiceUser();

    // Remplacez l'ID par l'ID de l'utilisateur que vous souhaitez récupérer
    int userId = 1; // Remplacez par l'ID souhaité

    // Appelez la méthode getById pour récupérer l'utilisateur par son ID
    User retrievedUser = serviceUser.getById(userId);

    if (retrievedUser != null) {
        // Si l'utilisateur est trouvé, affichez-le
        System.out.println("Retrieved User: " + retrievedUser);
    } else {
        // Si l'utilisateur n'est pas trouvé, affichez un message d'erreur
        System.out.println("User not found with ID: " + userId);
    }*/
    }  
}
    
    

